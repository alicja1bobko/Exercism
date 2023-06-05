package exercism;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ProteinTranslator {
    public static Map<String, String> codonProtein;

    static {
        codonProtein = new HashMap<>();
        codonProtein.put("AUG", "Methionine");
        asList("UUU", "UUC").forEach(code -> codonProtein.put(code, "Phenylalanine"));
        asList("UUA", "UUG").forEach(code -> codonProtein.put(code, "Leucine"));
        asList("UCU", "UCC", "UCA", "UCG").forEach(code -> codonProtein.put(code, "Serine"));
        asList("UAU", "UAC").forEach(code -> codonProtein.put(code, "Tyrosine"));
        asList("UGU", "UGC").forEach(code -> codonProtein.put(code, "Cysteine"));
        codonProtein.put("UGG", "Tryptophan");
        asList("UAA", "UAG", "UGA").forEach(code -> codonProtein.put(code, "STOP"));
    }

    public List<String> translate(String rnaSequence) {
        AtomicInteger nbrOfChars = new AtomicInteger(0);

        return rnaSequence.chars()
                .mapToObj(letter -> String.valueOf((char) letter))
                .collect(Collectors.groupingBy(letter -> nbrOfChars.getAndIncrement() / 3, Collectors.joining()))
                .values()
                .stream()
                .takeWhile(sequence -> !codonProtein.get(sequence).equals("STOP")).map(sequence -> codonProtein.get(sequence))
                .collect(Collectors.toList());
    }
}
