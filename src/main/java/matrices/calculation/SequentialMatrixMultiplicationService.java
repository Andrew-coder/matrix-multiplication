package matrices.calculation;

public class SequentialMatrixMultiplicationService extends MatrixMultiplicationService {


    @Override
    public int[][] multiplySquareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] secondTransposedMatrix = transposeSquaredMatrix(secondMatrix);
        int[][] multiplicationResult = new int[firstMatrix.length][firstMatrix.length];

        for (int i = 0; i < firstMatrix.length; ++i) {
            for (int j = 0; j < firstMatrix.length; ++j) {
                int sum = 0;
                for (int k = 0; k < firstMatrix.length; ++k) {
                    sum = (sum + (firstMatrix[i][k] * secondTransposedMatrix[j][k]));
                }
                multiplicationResult[i][j] = sum;
            }
        }

        return multiplicationResult;
    }
}
