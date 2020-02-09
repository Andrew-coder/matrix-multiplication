package matrices.calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelMultiplicationService extends MatrixMultiplicationService {

    private final ExecutorService multiplicationExecutorService;

    ParallelMultiplicationService() {
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        multiplicationExecutorService = Executors.newFixedThreadPool(numberOfCores + 1);
    }

    @Override
    public int[][] multiplySquareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] secondMatrixTransposed = transposeSquaredMatrix(secondMatrix);
        int[] multiplicationResult = new int[firstMatrix.length * firstMatrix.length];
        int multiplicationTaskCount = firstMatrix.length;

        List<CompletableFuture> multiplicationTasks = new ArrayList<>(multiplicationTaskCount);
        int currentOffset = 0;
        for (int[] row : firstMatrix) {
            multiplicationTasks.add(CompletableFuture.runAsync(new SimpleMultiplicationTask(currentOffset, row, secondMatrixTransposed, multiplicationResult), multiplicationExecutorService));
            currentOffset += row.length;
        }
        CompletableFuture<int[][]> computationResult = CompletableFuture.allOf(multiplicationTasks.toArray(new CompletableFuture[multiplicationTaskCount]))
                .thenApply((result) -> convertToTwoDimensionalArray(multiplicationResult, firstMatrix.length));
        try {
            return computationResult.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Unknown error occurred during matrix multiplication");
        }
    }

    private int[][] convertToTwoDimensionalArray(int[] flatArray, int size) {
        int[][] twoDimensionalArray = new int[size][size];
        for(int i = 0; i < size; ++i) {
            System.arraycopy(flatArray, i * size, twoDimensionalArray[i], 0, size);
        }

        return twoDimensionalArray;
    }
}
