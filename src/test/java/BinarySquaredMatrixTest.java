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
                {1, 0, 1},
                {0, 0, 1},
                {1, 1, 1}};
        int[][] secondMatrixValues = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        BinarySquaredMatrix firstMatrix = new BinarySquaredMatrix(firstMatrixValues);
        BinarySquaredMatrix secondMatrix = new BinarySquaredMatrix(secondMatrixValues);

        int[][] expectedMatrixValues = new int[][] {
                {0, 0, 1},
                {0, 0, 0},
                {1, 1, 0}
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
                {1, 0, 1},
                {0, 0, 1},
                {1, 1, 1}};
        int[][] secondMatrixValues = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        BinarySquaredMatrix firstMatrix = new BinarySquaredMatrix(firstMatrixValues);
        BinarySquaredMatrix secondMatrix = new BinarySquaredMatrix(secondMatrixValues);

        int[][] expectedMatrixValues = new int[][] {
                {0, 0, 1},
                {0, 0, 0},
                {1, 1, 0}
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
    public void newBinarySquaredMatrix_shouldThrowIllegalArgumentException_whenMatrixContainsNonBinaryElements() {
        // Given
        int[][] nonSquaredMatrixValues = new int[][]{
                {1, 0, 1},
                {0, 4, 1},
                {1, 1, 0}};

        // When
        new BinarySquaredMatrix(nonSquaredMatrixValues);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newBinarySquaredMatrix_shouldThrowIllegalArgumentException_whenMatrixValuesAreNull() {
        // When
        new BinarySquaredMatrix(null);
    }
}
