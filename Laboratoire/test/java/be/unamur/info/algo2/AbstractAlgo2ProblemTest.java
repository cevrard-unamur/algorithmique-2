package be.unamur.info.algo2;

import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

abstract public class AbstractAlgo2ProblemTest {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractAlgo2ProblemTest.class);
    protected Main main;

    AbstractAlgo2ProblemTest() {
        main = new Main();
    }

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder(); // Create a temporary folder for outputs deleted after tests

    @Rule
    public TestRule watcher = new TestWatcher() { // Prints message on logger before each test
        @Override
        protected void starting(Description description) {
            LOG.info(String.format("Starting test: %s()...",
                    description.getMethodName()));
        }
        ;
    };


    public static void checkResult(Object[] o_expected, Object[] o_result) {
        if (o_expected == null) {
            assertThat("Expected an error in the file", o_result == null);
        } else {
            String[] result = Arrays.copyOf(o_result, o_result.length, String[].class);
            String[] expected = Arrays.copyOf(o_expected, o_expected.length, String[].class);
            assertThat("Testing size array: expected " + expected.length + ", got " + result.length, result.length == expected.length);

            for (int i = 0; i < expected.length; i++) {
                assertThat("Testing value[" + i + "]: expected " + expected[i] + ", got " + result[i], result[i].equals(expected[i]));
            }
        }
    }

    public static String[] getResultContent(String s_file) {
        File jsonInputFile = new File(s_file);
        InputStream is;

        try {
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonArray array = reader.readArray();
            reader.close();

            if (array.get(0).toString().equals("null")) {
                return null;
            }

            String[] result = new String[array.size()];

            for (int i = 0; i < array.size(); i++) {
                result[i] = String.valueOf(array.get(i).toString());
            }

            return result;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    abstract protected String[] loadResult(String path) throws Exception;
    abstract protected String[] loadResultNaive(String path) throws Exception;

    protected void testFile(String filePath) throws Exception {
        String[] result = loadResult(filePath + ".txt");
        String[] s_result = AbstractAlgo2ProblemTest.getResultContent(filePath + ".json");
        AbstractAlgo2ProblemTest.checkResult(s_result, result);
    }

    protected void testFileNaive(String filePath) throws Exception {
        String[] result = loadResultNaive(filePath + ".txt");
        String[] s_result = AbstractAlgo2ProblemTest.getResultContent(filePath + ".json");
        AbstractAlgo2ProblemTest.checkResult(s_result, result);
    }
}
