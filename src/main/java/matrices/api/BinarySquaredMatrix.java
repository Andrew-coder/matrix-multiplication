package matrices.api;

import matrices.calculation.MatrixMultiplicationStrategyFactory;
import matrices.calculation.MatrixMultiplicationService;
import matrices.calculation.MatrixMultiplicationType;

import java.util.Arrays;
import java.util.Random;

public class BinarySquaredMatrix {

    private final int[][] values;

    public BinarySquaredMatrix(int size) {
        this(generateRandomMatrix(size));
    }

    public BinarySquaredMatrix(int[][] values) {
        if(!MatrixValidator.isValidMatrix(values)) {
            throw new IllegalArgumentException("given matrix values are invalid");
        }
        this.values = deepCopy(values);
    }

    public BinarySquaredMatrix multiply(BinarySquaredMatrix matrix) {
        MatrixMultiplicationService sequentialMultiplicationStrategy
                = MatrixMultiplicationStrategyFactory.getMatrixMultiplicationStrategyForType(MatrixMultiplicationType.SEQUENTIAL);

        return new BinarySquaredMatrix(sequentialMultiplicationStrategy.multiplySquareMatrices(values, matrix.getValues()));
    }

    public BinarySquaredMatrix multiplyParallel(BinarySquaredMatrix matrix) {
        MatrixMultiplicationService parallelMultiplicationStrategy
                = MatrixMultiplicationStrategyFactory.getMatrixMultiplicationStrategyForType(MatrixMultiplicationType.PARALLEL);

        return new BinarySquaredMatrix(parallelMultiplicationStrategy.multiplySquareMatrices(values, matrix.getValues()));
    }

    @Override
    public String toString() {
        return "matrices.api.BinarySquaredMatrix{" +
                "values=" + Arrays.deepToString(values) +
                '}';
    }

    public int[][] getValues() {
        return deepCopy(values);
    }

    public int getSize() {
        return values.length;
    }

    private static int[][] generateRandomMatrix(int size) {
        Random random = new Random();
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = random.nextInt(10);
            }
        }
        return result;
    }

    private static int[][] deepCopy(int[][] matrix) {
        return Arrays.stream(matrix).map(int[]::clone).toArray($ -> matrix.clone());
    }
}
