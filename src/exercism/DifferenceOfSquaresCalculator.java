package exercism;

import java.util.stream.IntStream;

public class DifferenceOfSquaresCalculator {

    private int computeSquareOfSumTo(int input) {
        IntStream stream = IntStream.range(1, input + 1);
        return (int) Math.pow(stream.reduce(0, (sum, num) -> sum + num), 2);
    }

    private int computeSumOfSquaresTo(int input) {
        IntStream stream = IntStream.range(1, input + 1);
        return stream.reduce(0, (sum, num) -> (int) (sum + Math.pow(num, 2)));
    }

    public int computeDifferenceOfSquares(int input) {
        return Math.abs(computeSumOfSquaresTo(input) - computeSquareOfSumTo(input));
    }

}