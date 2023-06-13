package exercism;

import java.util.stream.Collectors;

public class RotationalCipher {

    private final int shiftKey;

    public RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    public String rotate(String data) {
        return data.chars()
                .mapToObj(c -> {
                    if (Character.isLetter(c)) {
                        char base = Character.isUpperCase(c) ? 'A' : 'a';
                        int offset = (c - base + shiftKey) % 26;
                        return String.valueOf((char) (base + offset));
                    } else {
                        return String.valueOf((char) c);
                    }
                }).collect(Collectors.joining());
    }

}
