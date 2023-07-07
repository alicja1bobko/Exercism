package exercism;

import java.util.List;

public class BinarySearch {

    private final List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }


    public int indexOf(int value) throws ValueNotFoundException {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (int) Math.floor((left + right) / 2);
            int midValue = list.get(mid);
            if (midValue < value) {
                left = mid + 1;
            } else if (midValue > value) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        throw new ValueNotFoundException("Value not in array");
    }
}


