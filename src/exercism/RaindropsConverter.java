package exercism;

public class RaindropsConverter {

    public String convert(int number) {
        StringBuilder raindrops = new StringBuilder("");
        if (number % 3 == 0) raindrops.append("Pling");
        if (number % 5 == 0) raindrops.append("Plang");
        if (number % 7 == 0) raindrops.append("Plong");
        if (raindrops.isEmpty()) raindrops.append(String.valueOf(number));
        return raindrops.toString();
    }

}


