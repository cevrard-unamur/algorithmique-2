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

public class Algo2Problem2Test {

    private static final Logger LOG = LoggerFactory.getLogger(Algo2Problem2Test.class);

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
    public void test_problem_2() throws Exception{
        Algo2Problem2Test.testFile("src/test/resources/problem2/ProgrammationDynamique_3.2");
    }

    @Test
    public void test_problem_2_naive() throws Exception{
        Algo2Problem2Test.testFileNaive("src/test/resources/problem2/ProgrammationDynamique_3.2");
    }

    @Test
    public void test_problem_2_empty_file() throws Exception {
        Algo2Problem2Test.testFile("src/test/resources/problem2/EmptyFileTest");
        Algo2Problem2Test.testFileNaive("src/test/resources/problem2/EmptyFileTest");
    }

    @Test
    public void test_problem_2_incorrect_number_of_tests() throws Exception {
        Algo2Problem2Test.testFile("src/test/resources/problem2/IncorrectNumberOfTests");
        Algo2Problem2Test.testFileNaive("src/test/resources/problem2/IncorrectNumberOfTests");
    }

    @Test
    public void test_problem_2_negative_number_of_tests() throws Exception {
        Algo2Problem2Test.testFile("src/test/resources/problem2/NegativeNumberOfTests");
        Algo2Problem2Test.testFileNaive("src/test/resources/problem2/NegativeNumberOfTests");
    }

    @Test
    public void test_problem_2_incorrect_map_1() throws Exception {
        Algo2Problem2Test.testFile("src/test/resources/problem2/IncorrectMap1");
        Algo2Problem2Test.testFileNaive("src/test/resources/problem2/IncorrectMap1");
    }

    @Test
    public void test_problem_2_incorrect_map_2() throws Exception {
        Algo2Problem2Test.testFile("src/test/resources/problem2/IncorrectMap2");
        Algo2Problem2Test.testFileNaive("src/test/resources/problem2/IncorrectMap2");
    }

    @Test
    public void test_problem_2_incorrect_map_3() throws Exception {
        Algo2Problem2Test.testFile("src/test/resources/problem2/IncorrectMap3");
        Algo2Problem2Test.testFileNaive("src/test/resources/problem2/IncorrectMap3");
    }

    @Test
    public void test_problem_2_jenkins_test1() throws Exception{
        Algo2Problem2Test.testFile("src/test/resources/problem2/JenkinsTests/test1");
    }
    @Test
    public void test_problem_2_jenkins_test2() throws Exception{
        Algo2Problem2Test.testFile("src/test/resources/problem2/JenkinsTests/test2");
    }

    private static String[] loadResult(String path) throws Exception {
        return new Main().problem_2(FileHelper.getFileText(path));
    }

    private static void testFile(String filePath) throws Exception {
        String[] result = Algo2Problem2Test.loadResult(filePath + ".txt");
        String[] s_result = TestHelper.getResultContent(filePath + ".json");
        TestHelper.checkResult(s_result, result);
    }

    private static String[] loadResultNaive(String path) throws Exception {
        return new Main().problem_2_naive(FileHelper.getFileText(path));
    }

    private static void testFileNaive(String filePath) throws Exception {
        String[] result = Algo2Problem2Test.loadResultNaive(filePath + ".txt");
        String[] s_result = TestHelper.getResultContent(filePath + ".json");
        TestHelper.checkResult(s_result, result);
    }
}