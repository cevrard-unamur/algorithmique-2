package be.unamur.info.algo2;

import be.unamur.info.algo2.helper.FileHelper;
import org.junit.Test;

public class Algo2Problem1Test extends AbstractAlgo2ProblemTest {

    protected String[] loadResult(String path) throws Exception {
        return main.problem_1(FileHelper.getFileText(path));
    }

    protected String[] loadResultNaive(String path) throws Exception {
        return main.problem_1_naive(FileHelper.getFileText(path));
    }

    /* TESTS: */

    @Test
    public void test_problem_1() throws Exception{
        testFile("src/test/resources/problem1/DiviserPourRegner_2.2");
    }

    @Test
    public void test_problem_1_naive() throws Exception{
        testFileNaive("src/test/resources/problem1/DiviserPourRegner_2.2");
    }

    @Test
    public void test_problem_1_additional1() throws Exception{
        /* additional test file from G. Goddart */
        testFileNaive("src/test/resources/problem1/additionals/additional1");
        testFile("src/test/resources/problem1/additionals/additional1");
    }

    @Test
    public void test_problem_1_additional2() throws Exception{
        /* additional test file from G. Goddart */
        testFileNaive("src/test/resources/problem1/additionals/additional2");
        testFile("src/test/resources/problem1/additionals/additional2");
    }

    @Test
    public void test_problem_1_additional3() throws Exception{
        /* additional test file from G. Goddart */
        testFileNaive("src/test/resources/problem1/additionals/additional3");
        testFile("src/test/resources/problem1/additionals/additional3");
    }
}