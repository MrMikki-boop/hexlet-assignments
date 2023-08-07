package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {
            boolean matches = true;
            for (Map.Entry<String, String> entry : where.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!book.containsKey(key) || !book.get(key).equals(value)) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                result.add(book);
            }
        }

        return result;
    }
}
//END
