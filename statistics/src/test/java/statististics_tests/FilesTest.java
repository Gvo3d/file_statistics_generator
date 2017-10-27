package statististics_tests;

import org.junit.Test;
import org.yakimovdenis.statistics.LineStatisticsResult;
import org.yakimovdenis.statistics.StatisticsFileReader;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.List;

import static org.junit.Assert.*;

public class FilesTest {

    @Test
    public void NormalTest() throws NoSuchFileException {
        doTest("normal_test.txt", 11);
    }

    @Test
    public void NormalTestWithLastEmptyLine() throws NoSuchFileException {
        //Real file length is 12
        doTest("normal_test_with_last_empty_line.txt", 11);
    }

    @Test
    public void EmptyTest() throws NoSuchFileException {
        doTest("empty_test.txt", 0);
    }

    @Test
    public void EmptyLinesTest() throws NoSuchFileException {
        //Real file length is 13
        doTest("empty_lines_test.txt", 12);
    }

    @Test(expected = NoSuchFileException.class)
    public void noFile() throws NoSuchFileException {
        doTest("no_test.txt", 0);

    }

    private void doTest(String fileName, int expectedLinesCount) throws NoSuchFileException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(fileName).getFile());
        } catch (NullPointerException e) {
            file = new File(fileName);
        }
        StatisticsFileReader statisticsReader = new StatisticsFileReader();
        List<LineStatisticsResult> results;
        results = statisticsReader.resolveFile(file);
        assertNotNull(results);
        System.out.println("STATISTICS for " + fileName);
        int i = 1;
        for (LineStatisticsResult lineStatisticsResult : results) {
            System.out.println("LINE № " + i++);
            System.out.println(lineStatisticsResult);
            System.out.println(System.lineSeparator());
        }
        assertEquals(expectedLinesCount, results.size());
    }
}
