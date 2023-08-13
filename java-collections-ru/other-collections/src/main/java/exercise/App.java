package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();

        Set<String> allKeys = new TreeSet<>(data1.keySet());
        allKeys.addAll(data2.keySet());

        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 == null && value2 != null) {
                result.put(key, "added");
            } else if (value1 != null && value2 == null) {
                result.put(key, "deleted");
            } else if (value1 != null && value2 != null) {
                if (!value1.equals(value2)) {
                    result.put(key, "changed");
                } else {
                    result.put(key, "unchanged");
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Object> data1 = Map.of(
                "one", "eon",
                "two", "two",
                "four", true
        );

        Map<String, Object> data2 = Map.of(
                "two", "own",
                "zero", 4,
                "four", true
        );

        Map<String, String> result = App.genDiff(data1, data2);
        System.out.println(result); //=> {four=unchanged, one=deleted, two=changed, zero=added}
    }
}
//END
