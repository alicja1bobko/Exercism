package exercism;

import java.util.stream.IntStream;

public class PerfectNumbers {

    private final int naturalNumber;

    public PerfectNumbers(int naturalNumber) {
        if (naturalNumber == 0)
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        else if (naturalNumber < 0)
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        else this.naturalNumber = naturalNumber;
    }

    public Classification getClassification() {
        int aliquotSum = IntStream.range(1, this.naturalNumber)
                .filter(i -> this.naturalNumber % i == 0)
                .sum();
        if (aliquotSum == this.naturalNumber) return Classification.PERFECT;
        else if (aliquotSum > this.naturalNumber) return Classification.ABUNDANT;
        else return Classification.DEFICIENT;
    }
}
