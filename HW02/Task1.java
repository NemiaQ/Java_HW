//Дана строка sql-запроса "select * from students where ".
//        Сформируйте часть WHERE этого запроса, используя StringBuilder.
//        Данные для фильтрации приведены ниже в виде json строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
package HW02;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        String request = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":null}";
        Map<String, Object> data = jsonStringToMap(request);
        System.out.println(buildRequest(data));
    }

    public static Map<String, Object> jsonStringToMap(String content) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> data;
            data = objectMapper.readValue(content, new TypeReference<>() {
            });
            return data;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static StringBuilder buildRequest(Map<String, Object> data) {
        StringBuilder requestString = new StringBuilder();
        String[] keys = data.keySet().toArray(new String[0]);
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            Object value = data.get(key);
            if (value != null){
                if (i != 0) requestString.append(" and ");
                requestString.append(String.format("%s = \"%s\"", key,value));
            }
        }
        return requestString;
    }
}

