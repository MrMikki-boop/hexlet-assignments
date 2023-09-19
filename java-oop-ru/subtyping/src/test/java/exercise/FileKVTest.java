package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void testFileKV() {
        KeyValueStorage storage = new FileKV(filepath.toString(), new HashMap<>());

        storage.set("key1", "value1");
        storage.set("key2", "value2");

        assertThat(storage.get("key1", "default")).isEqualTo("value1");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");

        storage.unset("key1");
        assertThat(storage.get("key1", "default")).isEqualTo("default");

        // Check if data is persistent after reloading
        storage = new FileKV(filepath.toString(), new HashMap<>());
        assertThat(storage.get("key2", "default")).isEqualTo("value2");
    }

    @Test
    void testDefaultValue() {
        KeyValueStorage storage = new FileKV(filepath.toString(), new HashMap<>());
        assertThat(storage.get("nonexistent", "default")).isEqualTo("default");
    }

    @Test
    void testToMap() {
        KeyValueStorage storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key1", "value1");
        storage.set("key2", "value2");

        assertThat(storage.toMap()).isEqualTo(new HashMap<>(Map.of("key1", "value1", "key2", "value2")));
    }
    // END
}
