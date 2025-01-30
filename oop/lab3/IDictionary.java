package Lab3;

/**
 * Интерфейс IDictionary определяет контракт для работы со словарем.
 * Он обеспечивает функциональность перевода текста и загрузки словарных данных из файла.
 */

public interface IDictionary {
    String translate(String text);
    void loadDictionary(String filePath) throws FileReadException, InvalidFileFormatException;
}
