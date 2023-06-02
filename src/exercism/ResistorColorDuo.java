package exercism;
import java.util.Arrays;

public class ResistorColorDuo {
    private final String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet",  "grey", "white"};

    int colorCode(String color) {
        return  Arrays
                .asList(this.colors)
                .indexOf(color);
    }

    int value(String[] colors) {
        return Arrays
                .stream(colors)
                .limit(2)
                .mapToInt(this::colorCode)
                .reduce((a, b) -> a * 10 + b)
                .orElse(-1);
    }
}
