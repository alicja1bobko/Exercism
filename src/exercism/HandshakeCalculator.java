package exercism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandshakeCalculator {
    public List<Signal> calculateHandshake(int number) {
        String binaryNumber = Integer.toBinaryString(number);
        List<Signal> actionsList = new ArrayList<>();
        StringBuilder binaryNumberReversed = new StringBuilder();
        binaryNumberReversed.append(binaryNumber);
        binaryNumberReversed.reverse();
        for (int i = 0; i < binaryNumberReversed.length(); i++){
            switch(i){
                case 0:

                    if(String.valueOf(binaryNumberReversed.charAt(i)).equals("1")) actionsList.add(Signal.values()[i]);
                    break;
                case 1:

                    if(String.valueOf(binaryNumberReversed.charAt(i)).equals("1")) actionsList.add(Signal.DOUBLE_BLINK);
                    break;
                case 2:

                    if(String.valueOf(binaryNumberReversed.charAt(i)).equals("1")) actionsList.add(Signal.CLOSE_YOUR_EYES);
                    break;
                case 3:
                    if(String.valueOf(binaryNumberReversed.charAt(i)).equals("1")) actionsList.add(Signal.JUMP);
                    break;
                case 4:
                    if(String.valueOf(binaryNumberReversed.charAt(i)).equals("1")) Collections.reverse(actionsList);
                    break;
                default:
                    break;
            }
        }

        return actionsList;
    }


}
