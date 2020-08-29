package ConsoleApplication.CalculateNumberOfIslands;

import ConsoleApplication.CalculateNumberOfIslands.Beans.CalculateNumberOfIslandsBean;
import ConsoleApplication.CalculateNumberOfIslands.Beans.CreateInputMatrixFromFileBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootTest
class CalculateNumberOfIslandsApplicationTests {
	private String testDirectory = System.getProperty("user.dir") + "/TestData";

	@Autowired
	private CreateInputMatrixFromFileBean createMatrix;

	@Autowired
	private CalculateNumberOfIslandsBean calculateNumberOfIslands;

	@Test
	void exampleOceanWith5IslandsTest() {
		String fileDirectory = testDirectory + "/exampleOceanWith5IslandsTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 5;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );
		}
	}

	@Test
	void inputOceanWith2IslandsTest() {
		String fileDirectory = testDirectory + "/inputOceanWith2IslandsTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 2;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );
		}
	}

	@Test
	void oceanNonExistentTest() {
		String fileDirectory = testDirectory + "/oceanNonExistentTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 0;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );

		}
	}

	@Test
	void smallOceanWithNoIslandsTest() {
		String fileDirectory = testDirectory + "/smallOceanWithNoIslandsTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 0;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );

		}
	}

	@Test
	void largeOceanWithNoIslandsTest() {
		String fileDirectory = testDirectory + "/largeOceanWithNoIslandsTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 0;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );
		}
	}

	@Test
	void smallIslandNoOceanTest() {
		String fileDirectory = testDirectory + "/smallIslandNoOceanTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 1;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );
		}
	}

	@Test
	void largeIslandNoOceanTest() {
		String fileDirectory = testDirectory + "/largeIslandNoOceanTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 1;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );
		}
	}

	@Test
	void singleRowOceanWithIslandsTest() {
		String fileDirectory = testDirectory + "/singleRowOceanWithIslandsTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 3;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );
		}
	}

	@Test
	void singleColumnOceanWithIslandsTest() {
		String fileDirectory = testDirectory + "/singleColumnOceanWithIslandsTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 3;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );
		}
	}

	@Test
	void oceanWithIslandsInCornersTest() {
		String fileDirectory = testDirectory + "/oceanWithIslandsInCornersTest.txt";
		try {
			File file = new File(fileDirectory);
			int[][] input = createMatrix.createInputMatrix(file);
			int actual = calculateNumberOfIslands.calculateNrOfIslands(input);
			int expected = 4;
			Assertions.assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: File \"" + fileDirectory + "\" was not found." );
		}
	}
}
