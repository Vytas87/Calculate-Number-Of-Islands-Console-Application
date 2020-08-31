/*
 * CalculateNumberOfIslandsApplication is a console application that takes a binary two-dimensional array as an input
 * from the source code directory and calculates the number of islands (a group of connected 1s) in the ocean, for
 * example:
 *
 *       Input : mat[][] = {  {1, 1, 0, 0, 0},
 *                            {0, 1, 0, 0, 1},
 *                            {1, 0, 0, 1, 1},
 *                            {0, 0, 0, 0, 0},
 *                            {1, 0, 1, 0, 1} }
 *       Output : 5
 */

package ConsoleApplication.CalculateNumberOfIslands;

import ConsoleApplication.CalculateNumberOfIslands.Beans.CalculateNumberOfIslandsBean;
import ConsoleApplication.CalculateNumberOfIslands.Beans.CreateInputMatrixFromFileBean;
import ConsoleApplication.CalculateNumberOfIslands.Beans.GetListOfInputFilesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
public class CalculateNumberOfIslandsApplication implements CommandLineRunner {
    private String inputDirectory = System.getProperty("user.dir") + "/InputData";

    public static void main(String[] args) {
        SpringApplication.run(CalculateNumberOfIslandsApplication.class, args);
    }

    @Autowired
    // A component that collects a list of files in the given directory that are used to generate input data
    // (in this implementation, the source directory is built of .txt files that each has a single binary
    // two-dimensional array comprising of space separated 1s and 0s in a regular matrix fashion)
    private GetListOfInputFilesBean getListOfInputFiles;

    @Autowired
    // A component that creates an int[][] matrix from a file (formatted as described above)
    private CreateInputMatrixFromFileBean createMatrix;

    @Autowired
    // A component that solves the given problem - calculates the number of islands from a binary two-dimensional array
    private CalculateNumberOfIslandsBean calculateNumberOfIslands;

    @Override
    // Pre:     Reference directory/files exist and can be accessed
    //              (if not, NullPointerException is caught and the corrupted directory/file path is reported,
    //              or, SecurityException is caught and denial of access to the corrupted directory/file path reported)
    //          Reference file contains a single binary two-dimensional array comprising of space separated 1s and 0s
    //              in a regular matrix fashion
    //              (if not, NumberFormatException is caught and the corrupted file path is reported with a message
    //              specifying the required format)
    public void run(String... args) {
        // All files containing input data are ingested
        try {
            File[] inputFiles = getListOfInputFiles.getListOfInputFiles(inputDirectory);
            // For each file, the data is digested into int[][] and the number of islands is calculated
            for (File file : inputFiles) {
                try {
                    int[][] inputMatrix = createMatrix.createInputMatrix(file);
                    System.out.println();
                    String inputIntroMsg = "Input : mat[][] = ";
                    print(inputMatrix, inputIntroMsg);
                    int nrOfIslands = calculateNumberOfIslands.calculateNrOfIslands(inputMatrix);
                    System.out.println("Output : " + nrOfIslands);
                } catch (FileNotFoundException e) {
                    System.err.println("FileNotFoundException: File \"" + file + "\" was not found." );
                } catch (SecurityException e) {
                    System.err.println("SecurityException: File \"" + file + "\" cannot be accessed.");
                } catch (NumberFormatException e) {
                    System.err.println("NumberFormatException: The data in the \"" + file + "should contain a single " +
                            "binary two-dimensional array comprising of space separated 1s and 0s in a regular matrix" +
                            " fashion");
                }
            }
        } catch (NullPointerException e) {
            System.err.println("NullPointerException: Input file directory \""+ inputDirectory + "\" was not found.");
        } catch (SecurityException e) {
            System.err.println("SecurityException: Input file directory \"" + inputDirectory + "\" cannot be accessed.");
        }
    }

    // A method that prints the ingested input array out to the console for reference
    private void print(int[][] array, String inputIntroMsg) {
        // If the array is empty
        if (array.length == 0) {
            String emptyArray = inputIntroMsg + "{{}}";
            System.out.println(emptyArray);
        // If the array is not empty, a string representing each line to print is built and then printed
        } else {
            for (int i = 0; i < array.length; i++) {
                StringBuilder row = new StringBuilder();

                // First line
                if (i == 0) {
                    row.append(inputIntroMsg).append("{ ");       // the first line has a description
                // Subsequent lines
                } else {
                    // Leading space for the alignment of the array
                    // (the additional '+2' is to account for appending "{ " above)
                    for (int caretPosition = 0; caretPosition < inputIntroMsg.length() + 2; caretPosition++) {
                        row.append(" ");
                    }
                }

                row.append("{").append(array[i][0]);        // opening the first row

                int j = 1;
                while (j < array[i].length) {
                    row.append(", ").append(array[i][j]);  // appending all elements of the row
                    j++;
                }


                if (i < array.length - 1) {
                    row.append("},");           // closing of all inner rows
                } else {
                    row.append("} }");          // closing of the last row
                }

                System.out.println(row.toString());
            }
        }
    }
}
