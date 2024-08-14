package global.goit.edu.db;

import global.goit.edu.reader.Reader;

import java.nio.file.Files;
import java.nio.file.Path;

public class SqlFileReader implements Reader {
    @Override
    public String read(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
