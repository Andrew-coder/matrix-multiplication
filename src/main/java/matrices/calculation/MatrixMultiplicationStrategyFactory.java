package matrices.calculation;

import java.util.EnumMap;

public class MatrixMultiplicationStrategyFactory {

    private static final EnumMap<MatrixMultiplicationType, MatrixMultiplicationService> MATRIX_MULTIPLICATION_STRATEGIES
            = new EnumMap<>(MatrixMultiplicationType.class);

    static {
        MATRIX_MULTIPLICATION_STRATEGIES.put(MatrixMultiplicationType.SEQUENTIAL, new SequentialMatrixMultiplicationService());
        MATRIX_MULTIPLICATION_STRATEGIES.put(MatrixMultiplicationType.PARALLEL, new ParallelMultiplicationService());
    }

    public static MatrixMultiplicationService getMatrixMultiplicationStrategyForType(MatrixMultiplicationType multiplicationType) {
        return MATRIX_MULTIPLICATION_STRATEGIES.get(multiplicationType);
    }
}
