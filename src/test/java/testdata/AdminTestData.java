package testdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminTestData {
    public Map<String, Object> expectedDataMethod(String message, Integer statusCode, String path, Map<String, String> validationsmap) {

        Map<String, Object> expectedData = new HashMap<>();
        if (message != null) {//Eklemek istemediğim değerleri null atıyorum
            expectedData.put("message", message);
        }
        if (statusCode != null) {
            expectedData.put("statusCode", statusCode);
        }

        if (path != null) {
            expectedData.put("path", path);

        }
        if (validationsmap != null) {
            expectedData.put("validationsmap", validationsmap);
        }

        return expectedData;
    }

    public static String expectedDataInString(String message, Integer statusCode, String path, List<String> validationsmap) {

        return "{ \"message\": " + message + ", \"statusCode\": \"" + statusCode + "\", \"path\": " + path + ",\"validationsmap\":" + validationsmap + "}";

    }
}