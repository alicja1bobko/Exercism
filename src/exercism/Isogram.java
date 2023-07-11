package exercism;

import java.util.HashSet;
import java.util.Set;

public class Isogram {

    public static boolean isIsogram(String phrase) {
        String cleanedPhrase = removeSpacesAndHyphens(phrase);
        Set<Character> letterSet = new HashSet<>();
        for (char c : cleanedPhrase.toLowerCase().toCharArray()) {
            letterSet.add(c);
        }
        return cleanedPhrase.length() == letterSet.size();
    }

    private static String removeSpacesAndHyphens(String phrase) {
        return phrase.replaceAll("[\\s-]", "");
    }
}
