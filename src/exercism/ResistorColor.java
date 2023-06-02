package exercism;

import java.util.Arrays;

public class ResistorColor {
    private final String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int colorCode(String color) {
        return Arrays.asList(this.colors()).indexOf(color);
    }
    
    String[] colors() {
        return this.colors;
    }
}