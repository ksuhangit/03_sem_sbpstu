package Lab3_with_opp;

/**
 * Класс FileReadException пользовательское исключение для обработки ошибок, 
 * связанных с чтением файла.
*/

public class FileReadException extends Exception {
    public FileReadException(String message) {
        super(message);
    }
}