package backtracking;

public class RatInMaze {

	public enum Position {
		LEFT, RIGHT, UP, DOWN
	};

	static void findRatInMaze(int[][] arrQuestion) {
		int outerArrayLength = arrQuestion.length;
		int innerArrayLength = arrQuestion[0].length;
		int[][] arrAnswers = new int[outerArrayLength][innerArrayLength];

		int i = 0;
		int j = 0;
		int iDestination = outerArrayLength - 1;
		int jDestination = innerArrayLength - 1;
		boolean isFound = false;
		Position previousPosition;
		while (true) {
			int currVal = arrQuestion[i][j];
			if (currVal == 1) {
				arrAnswers[i][j] = 1;
				if (iDestination == i && jDestination == j) {
					isFound = true;
					break;
				} else {
					// find next element

					boolean isNextAvailable = false;

					// try down
					if (i + 1 <= iDestination && arrAnswers[i + 1][j] == 0 && arrQuestion[i + 1][j] == 1) {
						// down possible
						i++;
						previousPosition = Position.DOWN;
						isNextAvailable = true;
					} else if (i - 1 >= 0 && arrAnswers[i - 1][j] == 0 && arrQuestion[i - 1][j] == 1) {
						// up possible
						i--;
						previousPosition = Position.UP;
						isNextAvailable = true;
					} else if (j + 1 <= jDestination && arrAnswers[i][j + 1] == 0 && arrQuestion[i][j + 1] == 1) {
						// right possible
						j++;
						previousPosition = Position.RIGHT;
						isNextAvailable = true;
					} else if (j - 1 >= 0 && arrAnswers[i][j - 1] == 0 && arrQuestion[i][j - 1] == 1) {
						// left possible
						j--;
						previousPosition = Position.LEFT;
						isNextAvailable = true;
					}

					if (!isNextAvailable) {

					}
				}
			}
		}
		if (isFound) {
			System.out.println("Path found");
			displayArray(arrAnswers);
		}

	}

	public static void main(String[] args) {
		// @formatter:off
		int arrQuestion[][] = { { 1, 0, 1, 1, 1 }, 
								{ 1, 1, 1, 0, 1 }, 
								{ 0, 0, 0, 1, 1 }, 
								{ 0, 0, 0, 1, 0 },
								{ 0, 0, 0, 1, 1 } };
//		int arrQuestion[][] = { { 1, 0, 0 }, 
//								{ 1, 1, 0 }, 
//								{ 0, 1, 1 }}; 
		// @formatter:on
		RatInMaze.displayArray(arrQuestion);
		RatInMaze.findRatInMaze(arrQuestion);

	}

	public static void displayArray(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " | ");
			}
			System.out.println();
		}
	}
}
