package exercism;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Acronym {
    private final String acronym;

    public Acronym(String phrase) {
        this.acronym = Arrays
                .stream(phrase.split("[-_ ]+"))
                .map(word -> String.valueOf(word.charAt(0)).toUpperCase())
                .collect(Collectors.joining());
    }

    public String get() {
        return this.acronym;
    }

}
