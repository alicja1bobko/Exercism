package exercism;

import java.text.DecimalFormat;

public class SpaceAge {

    private final double seconds;

    public SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return this.seconds;
    }

    double onEarth() {
        double years = this.seconds / 3600 / 24 / 365.25;
        return twoDigitPrecision(years);
    }

    double twoDigitPrecision(double years) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedYears = decimalFormat.format(years);
        return Double.parseDouble(formattedYears);
    }

    double onMercury() {
        return twoDigitPrecision(onEarth() / 0.2408467);
    }

    double onVenus() {
        return twoDigitPrecision(onEarth() / 0.61519726);
    }

    double onMars() {
        return twoDigitPrecision(onEarth() / 1.8808158);
    }

    double onJupiter() {
        return twoDigitPrecision(onEarth() / 11.862615);
    }

    double onSaturn() {
        return twoDigitPrecision(onEarth() / 29.447498);
    }

    double onUranus() {
        return twoDigitPrecision(onEarth() / 84.016846);
    }

    double onNeptune() {
        return twoDigitPrecision(onEarth() / 164.79132);
    }

}
