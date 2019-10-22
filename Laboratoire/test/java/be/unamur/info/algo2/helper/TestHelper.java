package be.unamur.info.algo2.helper;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestHelper {
    public static void checkResult(Object[] o_expected, Object[] o_result) {
        if (o_expected == null) {
            assertThat("Error in the file", o_result == null);
        } else {
            String[] result = Arrays.copyOf(o_result, o_result.length, String[].class);
            String[] expected = Arrays.copyOf(o_expected, o_expected.length, String[].class);
            assertThat("Testing size array", result.length == expected.length);

            for (int i = 0; i < expected.length; i++) {
                assertThat("Testing value[" + i + "]", result[i].equals(expected[i]));
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
}
