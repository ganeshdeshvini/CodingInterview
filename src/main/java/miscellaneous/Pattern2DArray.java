package miscellaneous;

public class Pattern2DArray {

	public static void main(String[] args) {
		// @formatter:off
		int[][] pattern = {	{7, 9, 5, 0, 5, 1},
							{7, 9, 5, 0, 5, 1},
							{7, 3, 8, 9, 5, 1},
							{9, 5, 5, 3, 8, 1},
							{3, 8, 8, 3, 5, 1}}; 
		int[][] patternToSearch = {	{9, 5},
									{3, 8},
									};
		System.out.println(getOccurance(pattern, patternToSearch));
		// @formatter:on
	}

	static int getOccurance(int[][] pattern, int[][] patternToSearch) {
		int cnt = 0;
		int firstNum = patternToSearch[0][0];

		int patternLength = pattern.length;
		int patternToSearchLength = patternToSearch.length;
		int iLength = patternLength - patternToSearchLength;
		for (int i = 0; i <= iLength; i++) {
			int innerPatternLength = pattern[i].length;
			int innerPatternToSearchLength = patternToSearch[0].length;
			int jLength = innerPatternLength - innerPatternToSearchLength;
			for (int j = 0; j <= jLength; j++) {
				int val = pattern[i][j];
				if (val == firstNum) {
					int iIndex = i;
					int jIndex = j;
					if (isMatchFound(pattern, patternToSearch, iIndex, jIndex)) {
						cnt++;
					}
				}
			}
		}

		return cnt;
	}

	static boolean isMatchFound(int[][] pattern, int[][] patternToSearch, int iIndex, int jIndex) {
		int bkJIndex = jIndex;
		for (int k = 0; k < patternToSearch.length; k++) {
			jIndex = bkJIndex;
			for (int l = 0; l < patternToSearch[k].length; l++) {
				int valSearch = patternToSearch[k][l];
				int valPattern = pattern[iIndex][jIndex];

				if (valSearch != valPattern) {
					return false;
				}
				jIndex++;
			}
			iIndex++;
		}
		return true;
	}
}
