import matrices.api.BinarySquaredMatrix;

public class Main {

    public static void main(String[] args) {
        int matrixSize = Integer.valueOf(args[0]);
        BinarySquaredMatrix firstMatrix = new BinarySquaredMatrix(matrixSize);
        BinarySquaredMatrix secondMatrix = new BinarySquaredMatrix(matrixSize);

        long start = System.currentTimeMillis();
        BinarySquaredMatrix multiplicationResult = firstMatrix.multiply(secondMatrix);
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(String.format("Execution type for sequential algorithm: %d milliseconds", elapsedTime));
        System.out.println(multiplicationResult.getSize());

        start = System.currentTimeMillis();
        multiplicationResult = firstMatrix.multiplyParallel(secondMatrix);
        elapsedTime = System.currentTimeMillis() - start;
        System.out.println(String.format("Execution type for parallel algorithm: %d milliseconds", elapsedTime));
        System.out.println(multiplicationResult.getSize());
        System.exit(0);
    }
}
