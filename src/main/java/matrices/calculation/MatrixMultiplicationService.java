package matrices.calculation;

public abstract class MatrixMultiplicationService {

    public abstract int[][] multiplySquareMatrices(int[][] firstMatrix, int[][] secondMatrix);

    static int[][] transposeSquaredMatrix(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}
