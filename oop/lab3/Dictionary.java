package Lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary implements IDictionary {
	// Хранение словаря в виде отображения (Map) строк, где ключ - слово на исходном языке, а значение - перевод
	private Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }
    
    // Метод загрузки словаря из файла
    @Override
    public void loadDictionary(String filePath) throws FileReadException, InvalidFileFormatException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Чтение файла построчно
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|"); // Разделение строки на части по разделителю '|'
                if (parts.length != 2) { // Проверка на правильный формат строки - 2 части
                    throw new InvalidFileFormatException("Недопустимый формат в строке: " + line);
                }
                dictionary.put(parts[0].trim().toLowerCase(), parts[1].trim());
            }
        } catch (IOException e) {
        	// Обработка исключений при чтении файла
            throw new FileReadException("Ошибка чтения файла: " + e.getMessage());
        }
    }

    // Метод для перевода текста
    @Override
    public String translate(String text) {
    	// Разделение текста на фразы по запятой
        String[] phrases = text.split(",");
        StringBuilder result = new StringBuilder(); // Строковый строитель для формирования результата

        // Проход по каждой фразе
        for (String phrase : phrases) {
            String trimmedPhrase = phrase.trim(); // Удаление лишних пробелов
            String translated = translatePhrase(trimmedPhrase); // Перевод фразы
            result.append(translated).append(", "); // Добавление переведенной фразы в результат
        } 

        // Удаление последней запятой и пробела
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        
        return result.toString();
    }

    // Вспомогательный метод для перевода одной фразы
    private String translatePhrase(String phrase) {
        String bestMatch = null; // Для хранения лучшего совпадения
        int maxLength = 0; // Для хранения длины лучшего совпадения

        // Проход по всем ключам в словаре
        for (String key : dictionary.keySet()) {
            if (phrase.toLowerCase().contains(key)) {// Проверка, содержит ли фраза ключ (игнорируя регистр)
                if (key.length() > maxLength) { // Если длина текущего ключа больше максимальной, обновляем
                    maxLength = key.length();
                    bestMatch = key;
                }
            }
        }
     // Если найдено лучшее совпадение, заменяю его на перевод
        if (bestMatch != null) {
            return phrase.replace(bestMatch, dictionary.get(bestMatch));
        }

        return phrase; // Если перевода нет, возвращение оригинала
    }
}
