package aed;

import java.util.Comparator;

public class ReversoComparador implements Comparator<Integer> {
    public int compare (Integer a, Integer b) {
        return b.compareTo(a);
    }
}
