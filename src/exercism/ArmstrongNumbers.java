package exercism;

public class ArmstrongNumbers {
    public boolean isArmstrongNumber(int numberToCheck) {
        int numDigits = String.valueOf(numberToCheck).length();
        int sumOfDigits = (int) String.valueOf(numberToCheck).chars().mapToDouble(digit -> Math.pow(Character.getNumericValue(digit), numDigits)).sum();
        return (numberToCheck == sumOfDigits);
    }
}
