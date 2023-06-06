package exercism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HighScores {

    private final List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    List<Integer> scores() {
        return this.highScores;
    }

    Integer latest() {
        return this.highScores.get(highScores.size() - 1);
    }

    Integer personalBest() {
        return this.highScores.stream().reduce(Integer::max).orElseThrow();
    }

    List<Integer> personalTopThree() {
        List<Integer> sortedList = new ArrayList<>(this.highScores);
        sortedList.sort(Collections.reverseOrder());
        return sortedList.stream().limit(3).toList();
    }

}
