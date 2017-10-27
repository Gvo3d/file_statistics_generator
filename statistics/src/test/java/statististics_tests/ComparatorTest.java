package statististics_tests;

import org.junit.Test;
import org.yakimovdenis.stats.StringLengthComparator;

import static org.junit.Assert.*;

public class ComparatorTest {
    private String first = "first_string";
    private String second = "second";
    private String third = "second";

    @Test
    public void testStraight() {
        assertEquals(-1, doTest(true, first, second));
    }

    @Test
    public void testStraight2() {
        assertEquals(1, doTest(true, second, first));
    }

    @Test
    public void testReverse() {
        assertEquals(1, doTest(false, first, second));
    }

    @Test
    public void testReverse2() {
        assertEquals(-1, doTest(false, second, first));
    }

    @Test
    public void testEqual() {
        assertEquals(0, doTest(false, second, third));
    }

    private int doTest(boolean isMinimal, String first, String second) {
        return new StringLengthComparator(isMinimal).compare(first, second);
    }
}
