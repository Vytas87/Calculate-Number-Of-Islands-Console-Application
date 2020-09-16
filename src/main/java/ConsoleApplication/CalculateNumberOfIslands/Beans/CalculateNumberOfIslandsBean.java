/*
 * CalculateNumberOfIslandsBean component solves the given problem: given a binary two-dimensional array as an input, it
 * calculates the number of islands (a group of connected 1s)
 */

package ConsoleApplication.CalculateNumberOfIslands.Beans;

import org.springframework.stereotype.Component;

@Component
public class CalculateNumberOfIslandsBean {
    private int[][] mat;
    private int height;
    private int width;

    public CalculateNumberOfIslandsBean() {
        this(new int[0][0]);
    }

    public CalculateNumberOfIslandsBean(int[][] mat) {
        this.mat = mat;
        height = mat.length;
        if (height != 0) {
            width = mat[0].length;
        }
    }

    // O(nm) time | O(nm) space, where n and m are numbers of rows and columns in the matrix
    public int calculateNumberOfIslands() {
        // If the ocean is non-existent (no 1s, no 0s - no water, no islands)
        if (height == 0) return 0;

        // Initialize the 'unionOfIslands' object that will partition the 1s into disjoint sets, representing separate
        // islands
        UnionOfIslands unionOfIslands = new UnionOfIslands(height*width);

        // Traversing the input matrix so as to partition the 1s into disjoint sets - separate islands
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                // Once an island is encountered, the neighbours of the coordinate are checked and those are joined
                // that are also equal to 1
                if (mat[row][col] == 1) {
                    checkNeighbours(row, col, mat, unionOfIslands);
                }
            }
        }

        // At this point, all islands are partitioned into disjoint sets of a tree-like structure. The input matrix is
        // traversed again, but this time once an island is encountered, if it is encountered for the first time, it
        // is included in the total number of islands
        int[] frequencyOfIslandEncounters = new int[height*width];
        int numberOfIslands = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (mat[row][col] == 1) {

                    int rootIndex = unionOfIslands.findRoot(row * width + col);

                    // If frequency of set is 0,
                    // increment numberOfIslands
                    if (frequencyOfIslandEncounters[rootIndex] == 0) {
                        numberOfIslands++;
                    }
                    frequencyOfIslandEncounters[rootIndex]++;
                }
            }
        }
        return numberOfIslands;

    }

    private void checkNeighbours(int row, int col, int[][] mat, UnionOfIslands setOfIslands) {

        // The following numbers are used to refer to the indexes of the neighbour that is passed in
        int[] rowNr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] colNr = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int k = 0; k < 8; k++) {
            int neighbourRow = row + rowNr[k];
            int neighbourCol = col + colNr[k];

            // if the neighbouring coordinate is within the bounds of the input matrix and if the neighbour is also
            // 1, the two neighbours are joined
            if (isSafe(neighbourRow, neighbourCol) && mat[neighbourRow][neighbourCol] == 1) {
                setOfIslands.joinSets(row * width + col, neighbourRow * width + neighbourCol);
            }
        }
    }

    private boolean isSafe(int row, int col) {

        return row >= 0 && row < height && col >= 0 && col < width;
    }
}


// A helper class that puts connected components of an undirected graph as a collection of disjoint sets, where each
//      of the disjoint sets is put into a tree structure, the root of which is a representative member of a
//      particular disjoint set. A representative is determined while forming the disjoint sets
// In this case the islands (groups of connected 1s) can be viewed as connected components
class UnionOfIslands {
    // 'n' is the number of elements in the initial set (all elements of the input matrix)
    // 'parent' is an array where the i'th index of the array represents the i'th element of the initial set and the
    //      i'th element of the array represents the index of the parent of the i'th element of the initial set (all
    //      elements of the input matrix will be numbered in a row-major fashion)
    // 'rank' is an array where the i'th index of the array represents the i'th element of the initial set and the
    //      i'th element of the array represents the relative height of the tree from the i'th element of the initial
    //      set. The actual height might be smaller because the trees get flattened out by the application of the
    //      path compression method along the way
    private int n;
    private int[] parent, rank;

    UnionOfIslands(int n) {
        parent = new int[n];
        rank = new int[n];
        this.n = n;
        makeSet();
    }

    // Initially, all elements of the initial set are put into their own sets and they all are their own
    // representatives. Therefore, all 'rank' values are 0 because all trees representing the sets contain only one
    // member of the initial set
    private void makeSet() {
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    // Finds the index of the representative of the disjoint set that i is an element of
    // (finds the root of the tree which the disjoint set is represented by)
    public int findRoot(int i) {
        // if i is the parent itself, then i is the representative
        if (parent[i] == i) {
            return i;
        // otherwise, recursively find the index of the representative and apply the path compression method
        } else {
            int result = findRoot(parent[i]);
            parent[i] = result;     // the subtree from i is linked directly to the root of the tree, thereby
                                    // flattening the overall structure of the tree
            return result;
        }

    }

    // Joins the set that includes i'th element from the initial set and the set that includes j'th element from the
    // initial set
    public void joinSets(int i, int j) {
        // Find the representatives (the root nodes) for i an j
        int iRoot = findRoot(i);
        int jRoot = findRoot(j);

        // If elements are not in the same set
        if (iRoot != jRoot) {
            // If i's rank is less than j's rank, move i under j so that the height of the tree is smaller
            if (rank[iRoot] < rank[jRoot]) {
                parent[iRoot] = jRoot;
                // If j's rank is less than i's rank, move j under i
            } else if (rank[jRoot] < rank[iRoot]) {
                parent[jRoot] = iRoot;
                // Else if the ranks are equal, either of the trees is moved under the other, and the latter one's rank
                // is increased by 1
            } else {
                parent[jRoot] = iRoot;
                rank[iRoot]++;
            }
        }
    }
}
