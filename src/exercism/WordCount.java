package exercism;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        Arrays.stream(input
                        .toLowerCase()
                        .replaceAll("[^a-zA-Z0-9'\\s]+", " ")
                        .trim()
                        .split("\\s+"))
                .map(w -> w.replaceAll("^'|'$", ""))
                .forEach(w -> {
                    Integer count = wordCount.containsKey(w) ? wordCount.get(w) : 0;
                    wordCount.put(w, count + 1);
                });
        return wordCount;
    }
}
