package matrices.api;

import java.util.Objects;

class MatrixValidator {

    static boolean isValidMatrix(int[][] matrix) {
        return Objects.nonNull(matrix)
                && isSquaredMatrix(matrix)
                && isBinaryMatrix(matrix);
    }

    private static boolean isSquaredMatrix(int[][] matrix) {
        int rowsCount = matrix.length;
        for(int[] row: matrix) {
            if(row.length != rowsCount) {
                return false;
            }
        }

        return true;
    }

    private static boolean isBinaryMatrix(int[][] matrix) {
        for(int[] row: matrix) {
            for(int value: row) {
                if(value != 0 && value != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
