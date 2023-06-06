package exercism;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RnaTranscription {
    public static Map<String, String> dnaToRna;

    static {
        dnaToRna = new HashMap<>();
        dnaToRna.put("G", "C");
        dnaToRna.put("C", "G");
        dnaToRna.put("T", "A");
        dnaToRna.put("A", "U");
    }

    public String transcribe(String dnaStrand) {
        return dnaStrand.chars()
                .mapToObj(letter -> String.valueOf((char) letter))
                .map(letter -> dnaToRna.get(letter))
                .collect(Collectors.joining());
    }
}
