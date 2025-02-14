#include <iostream>
#include <string>

using namespace std;

// Функция для замены подстроки
string replace(string str, const string& from, const string& to) {
    size_t start_pos = str.find(from);
    if (start_pos != string::npos) {
        str.replace(start_pos, from.length(), to);
    }
    return str;
}

// Функция для применения правил алгоритма Маркова
string markovAlgorithm(string input) {
    // Правило 7:  -> * ; вставка в начало строки *
    input = "*" + input;

    while (true) {
        // Проверка, что хотя бы одно правило может быть применено
        bool changeMade = false;

        // Правило 2: *b -> b*
        if (input.find("*b") != string::npos) {
            input = replace(input, "*b", "b*");
            changeMade = true;
        }
        // Правило 1: *a -> a*
        if (input.find("*a") != string::npos) {
            input = replace(input, "*a", "a*");
            changeMade = true;
        }

        // Правило 4: b# -> #b
        if (input.find("b#") != string::npos) {
            input = replace(input, "b#", "#b");
            changeMade = true;
        }

        // Вытаскиваем последнее вхождение a и помечаем его
        size_t pos = input.find_last_of("a");
        if (pos != string::npos) {
            input.replace(pos, 1, "#");
            changeMade = true;
            // Выйдем из цикла, поскольку заменили последнее вхождение
            break;
        }

        // Если 'a' нет в строке, идем к правилу 6
        // Правило 6: # -> 
        if (input.find("#") != string::npos) {
            input = replace(input, "#", "");
            changeMade = true;
        }

        // Если нет символов и ничего не изменилось, завершаем цикл
        if (input.empty() || !changeMade) break;

        // Правило 3:   -> *
        if (input.empty()) input = "*";
    }

    // Правило 5: a# -> aa, окончательная замена
    size_t finalPos = input.find_last_of("#");
    if (finalPos != string::npos) {
        input.replace(finalPos, 1, "aa");
    }

    // Правило 6: # -> (пусто)
    input = replace(input, "#", "");

   
    input = replace(input, "*", "");

    return input;
}
bool isValidWord(const string& word) {
    for (char c : word) {
        if (c != 'a' && c != 'b') {
            return false; // Если найдена недопустимая буква, возвращаем false
        }
    }
    return true; // Если все буквы допустимы, возвращаем true
}

int main() {
    string word;

    cout << "Введите слово (алфавит a и b): ";
    cin >> word;
    // Проверка на допустимые символы
    if (!isValidWord(word)) {
        cout << "Ошибка: слово должно содержать только буквы 'a' и 'b'." << endl;
        return 1; // Завершаем выполнение программы с ошибкой
    }
    std::cout << "*a\t—> \ta*\n";
    std::cout << "*b\t—> \tb*\n";
    std::cout << "*\t—> \t#\n";
    std::cout << "b#\t—> \t#b\n";
    std::cout << "a#\t|—> \taa\n";
    std::cout << "#\t|—> \n";
    std::cout << "\t—> \t*\n";


    string result = markovAlgorithm(word);

    cout << "Результат замены: " << result << endl;

    return 0;
}
