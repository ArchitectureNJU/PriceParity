package architecture.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Object and json transfer with jackson
 * @author cuihao
 */
public class JsonMapping {
    private static ObjectMapper mapper = new ObjectMapper();
    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }
    public static Object toObject(String json, Class<?> clazz) {
        try {
            return mapper.readValue(json,clazz);
        } catch (IOException e) {
            return null;
        }
    }
}
