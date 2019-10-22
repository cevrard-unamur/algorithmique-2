package be.unamur.info.algo2.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {
    public static String getFileText(String input) throws IOException {
        return new String(Files.readAllBytes(Paths.get(input)));
    }
}
