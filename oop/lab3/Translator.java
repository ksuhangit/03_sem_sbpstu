package Lab3;

/**
 * Класс Translator отвечает за перевод текста с использованием переданного 
 * словаря, который реализует интерфейс IDictionary. Этот класс инкапсулирует 
 * логику перевода, делая систему более модульной и обеспечивая возможность 
 * использования разных словарей для перевода.
 */

public class Translator {
    private IDictionary dictionary;

    public Translator(IDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String translateText(String text) {
        return dictionary.translate(text);
    }
}
