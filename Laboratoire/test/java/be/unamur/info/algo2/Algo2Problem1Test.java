package be.unamur.info.algo2;

import be.unamur.info.algo2.helper.FileHelper;
import be.unamur.info.algo2.helper.TestHelper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Algo2Problem1Test {

    private static final Logger LOG = LoggerFactory.getLogger(Algo2Problem1Test.class);

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

    @Test
    public void test_problem_1() throws Exception{
        Algo2Problem1Test.testFile("src/test/resources/problem1/DiviserPourRegner_2.2");
    }

    @Test
    public void test_problem_1_naive() throws Exception{
        Algo2Problem1Test.testFileNaive("src/test/resources/problem1/DiviserPourRegner_2.2");
    }

    private static String[] loadResult(String path) throws Exception {
        return new Main().problem_1(FileHelper.getFileText(path));
    }

    private static void testFile(String filePath) throws Exception {
        String[] result = Algo2Problem1Test.loadResult(filePath + ".txt");
        String[] s_result = TestHelper.getResultContent(filePath + ".json");
        TestHelper.checkResult(s_result, result);
    }

    private static String[] loadResultNaive(String path) throws Exception {
        return new Main().problem_1_naive(FileHelper.getFileText(path));
    }

    private static void testFileNaive(String filePath) throws Exception {
        String[] result = Algo2Problem1Test.loadResultNaive(filePath + ".txt");
        String[] s_result = TestHelper.getResultContent(filePath + ".json");
        TestHelper.checkResult(s_result, result);
    }
}