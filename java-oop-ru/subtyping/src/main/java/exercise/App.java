package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        KeyValueStorage tempStorage = new InMemoryKV(storage.toMap());

        for (String key : storage.toMap().keySet()) {
            String value = storage.get(key, "");
            tempStorage.set(value, key);
        }

        storage.unset("");
        storage.unsetAll();

        for (String key : tempStorage.toMap().keySet()) {
            String value = tempStorage.get(key, "");
            storage.set(key, value);
        }
    }
}
// END
