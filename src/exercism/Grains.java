package exercism;

import java.math.BigInteger;

public class Grains {

    public static BigInteger grainsOnSquare(final int square) {
        if (square <= 64) {
            return BigInteger.valueOf(2).pow(square - 1);
        } else {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
    }

    BigInteger grainsOnBoard() {

        return BigInteger
                .valueOf(2)
                .pow(64)
                .subtract(BigInteger.ONE);
    }

}
