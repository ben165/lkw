package org.truck.helper;
import com.google.gson.Gson;
import org.truck.entity.LoadingScheme;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Json {
    static String filename = "loadingPlan.json";
    public static LoadingScheme readParameters() {
        String jsonStr = readFile(filename);
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, LoadingScheme.class);
    }

    private static String readFile(String filename) {
        Path filePath = Path.of(filename);
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
