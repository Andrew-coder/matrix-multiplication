package matrices;

import matrices.api.BinarySquaredMatrix;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MatrixMultiplicationBenchmark {

    @State(Scope.Thread)
    public static class SearchState {
        public int matrixSize = 1000;
        BinarySquaredMatrix firstMatrix = new BinarySquaredMatrix(matrixSize);
        BinarySquaredMatrix secondMatrix = new BinarySquaredMatrix(matrixSize);
    }

    @Benchmark
    public void testSequentialMatrixMultiplication(SearchState state) {
        BinarySquaredMatrix result = state.firstMatrix.multiply(state.secondMatrix);
        System.out.println(result.getValues().length);
    }

    @Benchmark
    public void testParallelMatrixMultiplication(SearchState state) {
        BinarySquaredMatrix result = state.firstMatrix.multiplyParallel(state.secondMatrix);
        System.out.println(result.getValues().length);
    }
}
