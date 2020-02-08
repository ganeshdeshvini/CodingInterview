package amazon;

/**
 * Created by ganesh deshvini on 11/27/2017.
 */
public class CountNegativeIntegersInRowColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] negativeRowColSortedMatrix = {
                {-3, -2, -1, 1},
                {-2, 2, 3, 4},
                {4, 5, 7, 8}
        };
        System.out.println("Naive solution: " + getNegativeIntegersCount(negativeRowColSortedMatrix));
        System.out.println("Optimal solution: " + getNegativeIntegersCountOptimalSolution(negativeRowColSortedMatrix));
    }

    static int getNegativeIntegersCount(int[][] negativeRowColSortedMatrix) {
        int count = 0;
        int iterationCount = 0;

        for (int i = 0; i < negativeRowColSortedMatrix.length; i++) {
            for (int j = 0; j < negativeRowColSortedMatrix[i].length; j++) {
                iterationCount++;
                if (negativeRowColSortedMatrix[i][j] >= 0) {
                    break;
                }
                count++;
            }
        }
        System.out.println("Iteration count: " + iterationCount);
        return count;
    }

    static int getNegativeIntegersCountOptimalSolution(int[][] negativeRowColSortedMatrix) {
        int count = 0;
        int iterationCount = 0;

        int j = negativeRowColSortedMatrix[0].length - 1;
        int i = 0;
        while (j >= 0) {
            iterationCount++;
            if (negativeRowColSortedMatrix[i][j] < 0) {
                count += j + 1;
                i++;
            }
            j--;
        }
        System.out.println("Iteration count: " + iterationCount);
        return count;
    }
}
