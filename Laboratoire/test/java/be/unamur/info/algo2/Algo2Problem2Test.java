package be.unamur.info.algo2;

import be.unamur.info.algo2.helper.FileHelper;
import org.junit.Test;

public class Algo2Problem2Test extends AbstractAlgo2ProblemTest {

    protected String[] loadResult(String path) throws Exception {
        return main.problem_2(FileHelper.getFileText(path));
    }

    protected String[] loadResultNaive(String path) throws Exception {
        return main.problem_2_naive(FileHelper.getFileText(path));
    }

    /* TESTS: */

    @Test
    public void test_problem_2() throws Exception{
        testFile("src/test/resources/problem2/ProgrammationDynamique_3.2");
    }

    @Test
    public void test_problem_2_naive() throws Exception{
        testFileNaive("src/test/resources/problem2/ProgrammationDynamique_3.2");
    }

    @Test
    public void test_problem_2_empty_file() throws Exception {
        testFile("src/test/resources/problem2/EmptyFileTest");
        testFileNaive("src/test/resources/problem2/EmptyFileTest");
    }

    @Test
    public void test_problem_2_incorrect_number_of_tests() throws Exception {
        testFile("src/test/resources/problem2/IncorrectNumberOfTests");
        testFileNaive("src/test/resources/problem2/IncorrectNumberOfTests");
    }

    @Test
    public void test_problem_2_negative_number_of_tests() throws Exception {
        testFile("src/test/resources/problem2/NegativeNumberOfTests");
        testFileNaive("src/test/resources/problem2/NegativeNumberOfTests");
    }

    @Test
    public void test_problem_2_incorrect_map_1() throws Exception {
        testFile("src/test/resources/problem2/IncorrectMap1");
        testFileNaive("src/test/resources/problem2/IncorrectMap1");
    }

    @Test
    public void test_problem_2_incorrect_map_2() throws Exception {
        testFile("src/test/resources/problem2/IncorrectMap2");
        testFileNaive("src/test/resources/problem2/IncorrectMap2");
    }

    @Test
    public void test_problem_2_incorrect_map_3() throws Exception {
        testFile("src/test/resources/problem2/IncorrectMap3");
        testFileNaive("src/test/resources/problem2/IncorrectMap3");
    }

    @Test
    public void test_problem_2_jenkins_test1() throws Exception{
        testFile("src/test/resources/problem2/JenkinsTests/test1");
    }
    @Test
    public void test_problem_2_jenkins_test2() throws Exception{
        testFile("src/test/resources/problem2/JenkinsTests/test2");
    }
}