package main.java.stats;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
    private boolean min;

    public StringLengthComparator(boolean getMinimalLength) {
        this.min = getMinimalLength;
    }

    @Override
    public int compare(String o1, String o2) {
        return min ? -1 * (lengthComparing(o1.length(), o2.length())):lengthComparing(o1.length(), o2.length());
    }

    private int lengthComparing(int o1, int o2) {
        return min ? -1 * (o1 < o2 ? 1 : o1 > o2 ? -1 : 0) : (o1 < o2 ? 1 : o1 > o2 ? -1 : 0);
    }
}
