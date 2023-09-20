package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class FileKVTest {

    private static Path filePath = Path.of("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filePath, content, StandardOpenOption.CREATE);
    }

    @Test
    void fileKVTest() {
        KeyValueStorage storage = new FileKV(filePath.toString(), Map.of("key", "value"));
        assertThat(storage.get("key", "default")).isEqualTo("value");

        storage.set("key2", "value2");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");

        storage.unset("key2");
        assertThat(storage.get("key2", "default")).isEqualTo("default");

        // Проверяем, что данные внутри storage корректно обновлены
        assertThat(storage.get("key", "default")).isEqualTo("value");
        assertThat(storage.toMap()).isEqualTo(Map.of("key", "value"));
    }
}
