/*
 * CreateInputMatrixFromFileBean component creates an int[][] matrix from a file. By construction, an input file is
 * expected to contain a single binary two-dimensional array comprising of space separated 1s and 0s in a regular
 * matrix fashion.
 */

package ConsoleApplication.CalculateNumberOfIslands.Beans;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Component
public class CreateInputMatrixFromFileBean {

    // Pre:     Reference file exists (if not, FileNotFoundException is thrown)
    //          Reference file can be accessed (if not, SecurityException is thrown)
    //          Reference file contains a single binary two-dimensional array comprising of space separated 1s and 0s
    //              in a regular matrix fashion
    //              (if not, NumberFormatException is thrown if the parsed string is not of numeric type,
    //              or IllegalArgumentException is thrown if the resulting integer is not 1 or 0)
    public int[][] createInputMatrix(File file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file.getAbsolutePath()));

        // If the file is empty
        if (!input.hasNextLine()) {
            return new int[0][0];
        }

        int[][] inputMatrix = readInputMatrix(input);
        return inputMatrix;
    }

    private int[][] readInputMatrix(Scanner input) {
        List<List<Integer>> inputMatrixAsList = new ArrayList<>();
        while (input.hasNextLine()) {
            String[] rowOfNumbers = input.nextLine().split(" ");
            List<Integer> rowList = new ArrayList<>();
                for (String s : rowOfNumbers) {
                    int element = Integer.parseInt(s);
                    if (element != 0 && element != 1) {
                        throw new IllegalArgumentException("For input element: " + s);
                    }
                    rowList.add(element);
                }
            inputMatrixAsList.add(rowList);
        }
        int[][] inputMatrix = toIntArray(inputMatrixAsList);
        return inputMatrix;
    }

    private int[][] toIntArray(List<List<Integer>> list) {
        int[][] array = new int[list.size()][list.get(0).size()];
        Iterator<List<Integer>> listRowIterator = list.iterator();
        for (int i = 0; i < array.length; i++) {
            Iterator<Integer> listElementIterator = listRowIterator.next().iterator();
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = listElementIterator.next();
            }
        }
        return array;
    }
}
