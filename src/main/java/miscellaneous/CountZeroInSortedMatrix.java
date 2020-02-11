package miscellaneous;

public class CountZeroInSortedMatrix {
    public static void main(String[] args) {
        int[][] sortedMatrix = {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(getZeroCount(sortedMatrix));

    }

    static int getZeroCount(int[][] sortedMatrix) {
        int sumZeroCount = 0;
        //start from 1st row & rightmost col
        int colIndex = sortedMatrix.length - 1;
        int rowIndex = 0;
        while (rowIndex <= sortedMatrix[rowIndex].length - 1 && colIndex >= 0) {
            if (sortedMatrix[rowIndex][colIndex] == 1) {
                //if is 1 then all elements down (Column) will be 1 as they are sorted
                colIndex--;
            } else if (sortedMatrix[rowIndex][colIndex] == 0) {
                //if it is 0 then all elements on left (row) will be 0 as they are sorted
                sumZeroCount += colIndex + 1;
                rowIndex++;
                if (colIndex == 0) {
                    break;
                }
            }
        }
        return sumZeroCount;


    }
}
