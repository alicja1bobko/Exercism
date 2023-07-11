package exercism;

import java.util.HashSet;


public class Isogram {

    public static boolean isIsogram(String phrase) {
        return phrase.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .allMatch(new HashSet<>()::add);
    }

}
