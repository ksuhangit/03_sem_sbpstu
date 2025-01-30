package Lab3;

import java.util.Scanner;
import java.nio.file.Paths;

public class TranslatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Относительный путь к файлу, содержащему словарные данные
        String filePath = Paths.get("src", "Lab3", "dictionary.txt").toString();

        // Инициализация объекта словаря для перевода
        IDictionary dictionary = new Dictionary();
        try {
            dictionary.loadDictionary(filePath);
        } catch (FileReadException | InvalidFileFormatException e) {
            // Вывод сообщение об ошибке, если произошла ошибка при загрузке словаря
            System.err.println(e.getMessage());
            return;
        }

        // Создание объекта переводчика, передавая ему загруженный словарь
        Translator translator = new Translator(dictionary);
        System.out.println("Введите текст для перевода (или 'exit' для выхода):");

        while (true) {
            String inputText = scanner.nextLine();
            if (inputText.equalsIgnoreCase("exit")) {
                break;
            }

            // Перевод введенного текста с помощью объекта Translator
            String translatedText = translator.translateText(inputText);
            System.out.println("Перевод: " + translatedText); // Вывод переведенного текста на экран
        }

        scanner.close();
    }
}
