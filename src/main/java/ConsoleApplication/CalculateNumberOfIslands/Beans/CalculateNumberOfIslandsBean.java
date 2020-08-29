/*
 * CalculateNumberOfIslandsBean component solves the given problem: given a binary two-dimensional array as an input, it
 * calculates the number of islands (a group of connected 1s)
 */

package ConsoleApplication.CalculateNumberOfIslands.Beans;

import org.springframework.stereotype.Component;

@Component
public class CalculateNumberOfIslandsBean {

    // O(nm) time | O(nm) space, where n and m are numbers of rows and columns in the matrix
    public int calculateNrOfIslands(int[][] mat) {
        // If the ocean is non-existent
        if (mat.length == 0) return 0;

        int nrOfIslands = 0;

        // Creating a boolean matrix representing the size of the ocean to keep track of visited coordinates
        int height = mat.length;
        int width = mat[0].length;
        boolean[][] isVisited = new boolean[height][width];

        // Traversing the input matrix so as to find, explore and count the islands,
        // while keeping track of visited coordinates
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                // Only exploring unvisited coordinates
                if (!isVisited[row][col]) {
                    isVisited[row][col] = true;
                    // Once an island is encountered, the neighbours of the coordinate are explored so as to find
                    // the whole island and mark it (as well as update the count)
                    if (mat[row][col] == 1) {
                        exploreCoordinate(row, col, mat, isVisited);
                        nrOfIslands++;
                    }
                }
            }
        }

        return nrOfIslands;
    }

    // Exploring the neighbours of a coordinate
    private void exploreCoordinate(int row, int col, int[][] mat, boolean[][] isVisited) {
        topLeft(row, col, mat, isVisited);
        top(row, col, mat, isVisited);
        topRight(row, col, mat, isVisited);
        left(row, col, mat, isVisited);
        right(row, col, mat, isVisited);
        bottomLeft(row, col, mat, isVisited);
        bottom(row, col, mat, isVisited);
        bottomRight(row, col, mat, isVisited);
    }


    // The following methods are exploring specific neighbours of a coordinate subject to the limits of the ocean

    private void topLeft(int row, int col, int[][] mat, boolean[][] isVisited) {
        // If it is a valid coordinate and it has not been visited, then it is marked and explored further if it is part
        // of the island
        if (row - 1 >= 0 && col - 1 >= 0 && !isVisited[row - 1][col - 1]) {
            isVisited[row - 1][col - 1] = true;
            if (mat[row - 1][col - 1] == 1) {
                exploreCoordinate(row - 1, col - 1, mat, isVisited);
            }
        }
    }

    private void top(int row, int col, int[][] mat, boolean[][] isVisited) {
        // If it is a valid coordinate and it has not been visited, then it is marked and explored further if it is part
        // of the island
        if (row - 1 >= 0 && !isVisited[row - 1][col]) {
            isVisited[row - 1][col] = true;
            if (mat[row - 1][col] == 1) {
                exploreCoordinate(row - 1, col, mat, isVisited);
            }
        }
    }

    private void topRight(int row, int col, int[][] mat, boolean[][] isVisited) {
        // If it is a valid coordinate and it has not been visited, then it is marked and explored further if it is part
        // of the island
        if (row - 1 >= 0 && col + 1 < mat[0].length && !isVisited[row - 1][col + 1]) {
            isVisited[row - 1][col + 1] = true;
            if (mat[row - 1][col + 1] == 1) {
                exploreCoordinate(row - 1, col + 1, mat, isVisited);
            }
        }
    }

    private void left(int row, int col, int[][] mat, boolean[][] isVisited) {
        // If it is a valid coordinate and it has not been visited, then it is marked and explored further if it is part
        // of the island
        if (col - 1 >= 0 && !isVisited[row][col - 1]) {
            isVisited[row][col - 1] = true;
            if (mat[row][col - 1] == 1) {
                exploreCoordinate(row, col - 1, mat, isVisited);
            }
        }
    }

    private void right(int row, int col, int[][] mat, boolean[][] isVisited) {
        // If it is a valid coordinate and it has not been visited, then it is marked and explored further if it is part
        // of the island
        if (col + 1 < mat[0].length && !isVisited[row][col + 1]) {
            isVisited[row][col + 1] = true;
            if (mat[row][col + 1] == 1) {
                exploreCoordinate(row, col + 1, mat, isVisited);
            }
        }
    }

    private void bottomLeft(int row, int col, int[][] mat, boolean[][] isVisited) {
        // If it is a valid coordinate and it has not been visited, then it is marked and explored further if it is part
        // of the island
        if (row + 1 < mat.length && col - 1 >= 0 && !isVisited[row + 1][col - 1]) {
            isVisited[row + 1][col - 1] = true;
            if (mat[row + 1][col - 1] == 1) {
                exploreCoordinate(row + 1, col - 1, mat, isVisited);
            }
        }
    }

    private void bottom(int row, int col, int[][] mat, boolean[][] isVisited) {
        // If it is a valid coordinate and it has not been visited, then it is marked and explored further if it is part
        // of the island
        if (row + 1 < mat.length && !isVisited[row + 1][col]) {
            isVisited[row + 1][col] = true;
            if (mat[row + 1][col] == 1) {
                exploreCoordinate(row + 1, col, mat, isVisited);
            }
        }
    }

    private void bottomRight(int row, int col, int[][] mat, boolean[][] isVisited) {
        // If it is a valid coordinate and it has not been visited, then it is marked and explored further if it is part
        // of the island
        if (row + 1 < mat.length && col + 1 < mat[0].length && !isVisited[row + 1][col + 1]) {
            isVisited[row + 1][col + 1] = true;
            if (mat[row + 1][col + 1] == 1) {
                exploreCoordinate(row + 1, col + 1, mat, isVisited);
            }
        }
    }
}
