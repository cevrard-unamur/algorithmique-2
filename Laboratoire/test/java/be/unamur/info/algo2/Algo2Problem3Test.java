package be.unamur.info.algo2;

import be.unamur.info.algo2.helper.FileHelper;
import org.junit.Test;

public class Algo2Problem3Test extends AbstractAlgo2ProblemTest {

    protected String[] loadResult(String path) throws Exception {
        return main.problem_3(FileHelper.getFileText(path));
    }

    protected String[] loadResultNaive(String path) throws Exception {
        return main.problem_3_naive(FileHelper.getFileText(path));
    }

    /* TESTS: */

    @Test
    public void test_problem_3() throws Exception{
        testFile("src/test/resources/problem3/ProgrammationGlouton_4.2");
    }

    @Test
    public void test_problem_3_naive() throws Exception{
        testFileNaive("src/test/resources/problem3/ProgrammationGlouton_4.2");
    }

    @Test
    public void test_problem3_additional1() throws Exception {
        /* additional test file from Pierre Beaujean */
        testFile("src/test/resources/problem3/additionals/additional1");
        testFileNaive("src/test/resources/problem3/additionals/additional1");
    }
}