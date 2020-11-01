import matrices.api.BinarySquaredMatrix;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnit4.class)
public class BinarySquaredMatrixTest {

    @Test
    public void multiply_shouldMultiplyTwoSquareMatricesWithSizeThree() {
        // Given
        int[][] firstMatrixValues = new int[][]{
                {2, 0, 1},
                {1, 3, 1},
                {1, 2, 1}};
        int[][] secondMatrixValues = new int[][]{
                {0, 0, 1},
                {2, 1, 1},
                {3, 0, 1}
        };

        BinarySquaredMatrix firstMatrix = new BinarySquaredMatrix(firstMatrixValues);
        BinarySquaredMatrix secondMatrix = new BinarySquaredMatrix(secondMatrixValues);

        int[][] expectedMatrixValues = new int[][] {
                {3, 0, 3},
                {9, 3, 5},
                {7, 2, 4}
        };

        // When
        BinarySquaredMatrix actualResult = firstMatrix.multiply(secondMatrix);

        //Then
        assertArrayEquals(expectedMatrixValues, actualResult.getValues());
    }

    @Test
    public void multiplyParallel_shouldMultiplyTwoSquareMatricesWithSizeThree() {
        // Given
        int[][] firstMatrixValues = new int[][]{
                {2, 0, 1},
                {1, 3, 1},
                {1, 2, 1}};
        int[][] secondMatrixValues = new int[][]{
                {0, 0, 1},
                {2, 1, 1},
                {3, 0, 1}
        };

        BinarySquaredMatrix firstMatrix = new BinarySquaredMatrix(firstMatrixValues);
        BinarySquaredMatrix secondMatrix = new BinarySquaredMatrix(secondMatrixValues);

        int[][] expectedMatrixValues = new int[][] {
                {3, 0, 3},
                {9, 3, 5},
                {7, 2, 4}
        };

        // When
        BinarySquaredMatrix actualResult = firstMatrix.multiplyParallel(secondMatrix);

        //Then
        assertArrayEquals(expectedMatrixValues, actualResult.getValues());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newBinarySquaredMatrix_shouldThrowIllegalArgumentException_whenNonSquareMatrixIsPassed() {
        // Given
        int[][] nonSquaredMatrixValues = new int[][]{
                {1, 0},
                {0, 0,},
                {1, 1}};

        // When
        new BinarySquaredMatrix(nonSquaredMatrixValues);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newBinarySquaredMatrix_shouldThrowIllegalArgumentException_whenMatrixValuesAreNull() {
        // When
        new BinarySquaredMatrix(null);
    }
}
