package Lab3;

/**
 * Класс InvalidFileFormatException пользовательское исключение для обработки ошибок, 
 * связанных с недопустимым форматом файла. 
 */

public class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}
