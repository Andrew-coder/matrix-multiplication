package matrices.calculation;

public class SimpleMultiplicationTask implements Runnable {

    private final int workingOffset;
    private final int[] row;
    private final int[][] matrix;
    private final int[] multiplicationResult;

    SimpleMultiplicationTask(int workingOffset, int[] row, int[][] matrix, int[] multiplicationResult) {
        this.workingOffset = workingOffset;
        this.row = row;
        this.matrix = matrix;
        this.multiplicationResult = multiplicationResult;
    }

    @Override
    public void run() {
        int matrixLength = matrix.length;
        int currentOffset = workingOffset;
        for (int[] matrixRow : matrix) {
            int sum = 0;
            for (int k = 0; k < matrixLength; ++k) {
                sum = (sum + (row[k] & matrixRow[k])) % 2;
            }
            multiplicationResult[currentOffset] = sum;
            ++currentOffset;
        }
    }
}
