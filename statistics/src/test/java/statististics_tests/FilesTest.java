package statististics_tests;

import org.junit.Test;
import stats.LineStatisticsResult;
import stats.StaticticsFileReader;

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
        doTest("normal_test_with_last_empty_line.txt", 11);
    }

    @Test
    public void EmptyTest() throws NoSuchFileException {
        doTest("empty_test.txt", 0);
    }

    @Test
    public void EmptyLinesTest() throws NoSuchFileException {
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
        StaticticsFileReader statisticsReader = new StaticticsFileReader();
        List<LineStatisticsResult> results = null;
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
