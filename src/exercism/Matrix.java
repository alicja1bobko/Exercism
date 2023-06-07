package exercism;

import java.util.Arrays;

public class Matrix {
    private final int[][] matrix;

    public Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");

        matrix = Arrays.stream(rows)
                .map(row -> row.split("\\s+"))
                .map(rowElements -> Arrays.stream(rowElements)
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
    }

    public int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return Arrays
                .stream(matrix)
                .mapToInt(row -> row[columnNumber - 1])
                .toArray();
    }
}

