package statististics_tests;

import org.junit.Test;
import org.yakimovdenis.statistics.LineStatisticsResult;
import org.yakimovdenis.statistics.StatisticsResolver;

import java.util.List;

import static org.junit.Assert.*;

public class StatisticsTest {
    private String[] testText = {"a ba casgr rgew wedf ver most_long_word", "rtghth rgew gfg dfgdfg dfgf wedf ver most_long_word", "ewrwever 324r 23f23 vevre ver most_long_word"};
    private String[] emptyTestText = {"", "", "",""};
    private String[] nullTestText = {null, null, null,null,null};

    @Test
    public void normalTest(){
        doTest(testText,"most_long_word",3);
    }

    @Test
    public void emptyTest(){
        doTest(emptyTestText,"",4);
    }

    @Test
    public void nullTest(){
        doTest(nullTestText,null,5);
    }

    private void doTest(String[] target, String mostLongWord, int linesCount){
        StatisticsResolver resolver = new StatisticsResolver();
        List<LineStatisticsResult> results = resolver.getLineStatisticsForFile(target);
        for (LineStatisticsResult line: results){
            assertEquals(mostLongWord,line.getLongestWord());
            System.out.println(line);
            System.out.println(System.lineSeparator());
        }
        assertEquals(linesCount, results.size());
    }
}
