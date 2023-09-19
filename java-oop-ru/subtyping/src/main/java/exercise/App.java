package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        // Создаем временное in-memory хранилище
        KeyValueStorage tempStorage = new InMemoryKV(storage.toMap());

        // Получаем набор записей (пар ключ-значение) из исходного хранилища
        Set<Map.Entry<String, String>> entries = tempStorage.toMap().entrySet();

        // Очищаем исходное хранилище
        for (Map.Entry<String, String> entry : entries) {
            storage.unset(entry.getKey());
        }

        // Переставляем ключи и значения исходного хранилища
        for (Map.Entry<String, String> entry : entries) {
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
