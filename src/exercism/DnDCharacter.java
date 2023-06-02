package exercism;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DnDCharacter {
    private final int strength, dexterity, constitution, intelligence, wisdom, charisma, hitpoints;

    DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
        this.constitution = ability(rollDice());
        this.hitpoints = 10 + modifier(this.constitution);
    }

    int ability(List<Integer> scores) {
        List<Integer> sortedScores = new ArrayList<>(scores);
        sortedScores.sort(Comparator.reverseOrder());
        return sortedScores
                .stream()
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }

    List<Integer> rollDice() {
        return IntStream.range(0, 4)
                .map(i -> (int) (Math.random() * 6) + 1)
                .boxed()
                .collect(Collectors.toList());

    }

    int modifier(int input) {
        return (int) Math.floor((input - 10.0) / 2.0);
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
        return this.dexterity;
    }

    int getConstitution() {
        return this.constitution;
    }

    int getIntelligence() {
        return this.intelligence;
    }

    int getWisdom() {
        return this.wisdom;
    }

    int getCharisma() {
        return this.charisma;
    }

    int getHitpoints() {
        return this.hitpoints;
    }
}

