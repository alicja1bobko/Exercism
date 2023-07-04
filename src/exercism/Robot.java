package exercism;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Robot {

    private String robotName;
    private static final Random random = new Random();
    private static final Set<String> usedNames = new HashSet<>();


    public Robot() {
        reset();
    }

    private String generateName() {
        return randomChars(2, 'A', 'Z') + randomChars(3, '0', '9');
    }

    private String randomChars(int amount, char start, char end) {
        return random.ints(amount, start, end)
                .mapToObj(e -> (char) e)
                .map(Objects::toString)
                .collect(Collectors.joining());
    }

    public String getName() {
        return this.robotName;
    }

    public void reset() {
        usedNames.remove(this.robotName);
        String name;
        do {
            name = generateName();
        } while (usedNames.contains(name));

        usedNames.add(name);
        this.robotName = name;
    }

}