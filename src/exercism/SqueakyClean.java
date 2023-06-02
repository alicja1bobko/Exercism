package exercism;

import static java.lang.Character.*;

public class SqueakyClean {
    public static String clean(String identifier) {
        StringBuilder sB = new StringBuilder();
        boolean dash = false;
        for(int i = 0; i< identifier.length(); i++) {
            char character = identifier.charAt(i);
            if (character == ' ') {
                sB.append("_");
            } else if (character >= 'α' && character <= 'ω') {
                sB.append("");
            } else if (isISOControl(character)) {
                sB.append("CTRL");
            } else if (character == '-') {
                dash = true;
            }else if (isLetter(character)) {
                if (dash) {
                    sB.append(toUpperCase(character));
                    dash = false;
                } else {
                    sB.append(character);
                }
            }
        }
        return sB.toString();
    }
}


