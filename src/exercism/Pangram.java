package exercism;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pangram {
    Set<Character> alphabetSet = new HashSet<>(Set.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

    public boolean isPangram(String input) {
        Set<Character> lettersSet = new HashSet<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        pattern.matcher(input.toUpperCase())
                .results()
                .map(MatchResult::group)
                .collect(Collectors.joining())
                .chars()
                .forEach(character -> lettersSet.add((char) character));
        return lettersSet.equals(alphabetSet);
    }
}
