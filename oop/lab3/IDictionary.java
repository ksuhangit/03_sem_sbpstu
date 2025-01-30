package Lab3;

public interface IDictionary {
    String translate(String text);
    void loadDictionary(String filePath) throws FileReadException, InvalidFileFormatException;
}
