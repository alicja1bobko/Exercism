package exercism;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class Scrabble {
    private int wordScore;
    private static Map<Character, Integer> lookup = new HashMap<Character, Integer>(26);

    static {
        asList('a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't').forEach(c -> lookup.put(c, 1));
        asList('d', 'g').forEach(c -> lookup.put(c, 2));
        asList('b', 'c', 'm', 'p').forEach(c -> lookup.put(c, 3));
        asList('f', 'h', 'v', 'w', 'y').forEach(c -> lookup.put(c, 4));
        asList('k').forEach(c -> lookup.put(c, 5));
        asList('j', 'x').forEach(c -> lookup.put(c, 8));
        asList('q', 'z').forEach(c -> lookup.put(c, 10));
    }

    public Scrabble(String word) {
        this.wordScore = word
                .toLowerCase()
                .chars()
                .reduce(0, (score, letter) -> score + lookup.get((char) letter));
    }

    public int getScore() {
        return this.wordScore;
    }

}
