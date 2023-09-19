package exercise;

// BEGIN
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileKV implements KeyValueStorage {
    private Map<String, String> data;
    private String filePath;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.data = new HashMap<>(initialData);
        this.filePath = filePath;
        loadFromFile();
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        saveToFile();
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        saveToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }

    private void loadFromFile() {
        String fileContent = Utils.readFile(filePath);
        if (!fileContent.isEmpty()) {
            data = Utils.unserialize(fileContent);
        }
    }

    private void saveToFile() {
        String serializedData = Utils.serialize(data);
        Utils.writeFile(filePath, serializedData);
    }
}
// END
