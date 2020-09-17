package ConsoleApplication.CalculateNumberOfIslands;

import ConsoleApplication.CalculateNumberOfIslands.Beans.CreateInputMatrixFromFileBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootTest
public class CreateInputMatrixFromFileBeanTests {
    private String testDirectory = System.getProperty("user.dir") + "/TestData/CreateInputMatrixFromFileBeanTestsData";

    @Autowired
    private CreateInputMatrixFromFileBean createMatrix;

    @Test
    void emptyFileTest() throws FileNotFoundException {
        int[][] actual = createMatrix.createInputMatrix(new File(testDirectory + "/emptyFileTest.txt"));
        int[][] expected = new int[0][0];
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void nonNumericLiteralsTest_ThrowsNumberFormatException() {
        Assertions.assertThrows(NumberFormatException.class, () ->
                createMatrix.createInputMatrix(new File(testDirectory + "/nonNumericLiteralsTest.txt"))
        );
    }

    @Test
    void nonNumericLiteralsTest_ExceptionMessage() throws FileNotFoundException {
        try {
            createMatrix.createInputMatrix(new File(testDirectory + "/nonNumericLiteralsTest.txt"));
        } catch (NumberFormatException exception) {
            String actualMessage = exception.getMessage();
            String expectedMessage = "For input string: ";

            Assertions.assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    void inputMatrixElementsAreNot0or1_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                createMatrix.createInputMatrix(new File(testDirectory + "/inputMatrixElementsAreNot0or1.txt"))
        );
    }

    @Test
    void inputMatrixElementsAreNot0or1_ExceptionMessage() throws FileNotFoundException {
        try {
            createMatrix.createInputMatrix(new File(testDirectory + "/inputMatrixElementsAreNot0or1.txt"));
        } catch (IllegalArgumentException exception) {
            String actualMessage = exception.getMessage();
            String expectedMessage = "For input element: ";

            Assertions.assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    void rowsOfDifferentLengthTest_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                createMatrix.createInputMatrix(new File(testDirectory + "/rowsOfDifferentLengthTest.txt"))
        );
    }

    @Test
    void rowsOfDifferentLengthTest_ExceptionMessage() throws FileNotFoundException {
        try {
            createMatrix.createInputMatrix(new File(testDirectory + "/rowsOfDifferentLengthTest.txt"));
        } catch (IllegalArgumentException exception) {
            String actualMessage = exception.getMessage();
            String expectedMessage = "Input matrix has rows of different length.";

            Assertions.assertEquals(actualMessage, expectedMessage);
        }
    }
}
