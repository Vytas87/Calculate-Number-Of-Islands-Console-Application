package ConsoleApplication.CalculateNumberOfIslands;

import ConsoleApplication.CalculateNumberOfIslands.Beans.CalculateNumberOfIslandsBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculateNumberOfIslandsBeanTests {

	@Test
	void exampleOceanWith5IslandsTest() {
		int[][] input = {
				{1, 1, 0, 0, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 0, 1, 0, 1}
		};
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 5;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void inputOceanWith2IslandsTest() {
		int[][] input = {
				{1, 1, 0, 1, 0, 1, 1, 1, 1},
				{0, 1, 0, 1, 0, 1, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0, 1, 0, 0, 1},
				{1, 1, 1, 0, 0, 1, 1, 1, 1},
				{0, 0, 0, 1, 0, 1, 0, 0, 0},
				{0, 0, 1, 1, 1, 0, 1, 1, 1},
				{0, 1, 0, 1, 0, 1, 1, 0, 1}
		};
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 2;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void oceanNonExistentTest() {
		int[][] input = new int[0][0];
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 0;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void smallOceanWithNoIslandsTest() {
		int[][] input = {{0}};
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 0;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void largeOceanWithNoIslandsTest() {
		int[][] input = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 0;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void smallIslandNoOceanTest() {
		int[][] input = {{1}};
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 1;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void largeIslandNoOceanTest() {
		int[][] input = {
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 1;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void singleRowOceanWithIslandsTest() {
		int[][] input = {{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0}};
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 3;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void singleColumnOceanWithIslandsTest() {
		int[][] input = {
				{1},
				{1},
				{1},
				{0},
				{1},
				{1},
				{0},
				{0},
				{0},
				{1},
				{0}
		};
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 3;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void oceanWithIslandsInCornersTest() {
		int[][] input = {
				{1, 0, 0, 0, 1},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1}
		};
		CalculateNumberOfIslandsBean calculateNrOfIslands = new CalculateNumberOfIslandsBean(input);
		int actual = calculateNrOfIslands.calculateNumberOfIslands();
		int expected = 4;
		Assertions.assertEquals(expected, actual);
	}
}
