package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        try {
            String jsonRepresentation = car.serialize();
            if (jsonRepresentation != null) {
                Files.writeString(path, jsonRepresentation, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path path) {
        try {
            String jsonContent = Files.readString(path);
            return Car.unserialize(jsonContent);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
// END
