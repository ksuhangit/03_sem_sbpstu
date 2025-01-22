package Peano;

import java.util.Scanner;

public class NaturalNumber {
    private int value; // Значение натурального числа

    public NaturalNumber(int value) {
        // Проверка на корректность введенного значения
        if (value <= 0) { // Учитываем только положительные натуральные числа
            throw new IllegalArgumentException("Число должно быть положительным и натуральным."); // Исключение при неправильном значении
        }
        this.value = value; // Присваиваем значение полю класса
    }

    // Метод для получения значения натурального числа
    public int getValue() {
        return this.value; // Возвращаем значение натурального числа
    }

    // Метод для сложения натуральных чисел
    public NaturalNumber add(NaturalNumber other) {
        // Создаем новый объект NaturalNumber с суммой текущего и переданного чисел
        return new NaturalNumber(this.value + other.getValue());
    }

    // Метод для вычисления d(n)
    public NaturalNumber d() {
        // Определение функции d(n):
        // d(0) = 0, d(s(n)) = s(d(n)), где s(n) - следующий натуральный номер
        if (this.value == 0) {
            return new NaturalNumber(0); // Для 0, d(0) = 0
        } else {
            return new NaturalNumber(this.value); // Для всех n > 0, d(n) = n
        }
    }

    // Метод для проверки равенства d(x + y) и d(x) + d(y)
    public static void checkInduction(NaturalNumber x, NaturalNumber y) {
        // Находим сумму двух натуральных чисел
        NaturalNumber sum = x.add(y);
        // Вычисляем d(sum)
        NaturalNumber dSum = sum.d();
        // Вычисляем d(x) + d(y)
        NaturalNumber dXplusY = x.d().add(y.d());

        // Выводим результаты расчетов на экран
        System.out.println("d(" + x.getValue() + " + " + y.getValue() + ") = " + dSum.getValue());
        System.out.println("d(" + x.getValue() + ") + d(" + y.getValue() + ") = " + dXplusY.getValue());
        // Проверяем, равны ли результаты
        System.out.println("Утверждение верно: " + (dSum.getValue() == dXplusY.getValue()));
    }

    // Главный метод для запуска программы
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для работы с вводом пользователя
        NaturalNumber x = null; // Инициализируем переменную для первого натурального числа
        NaturalNumber y = null; // Инициализируем переменную для второго натурального числа

        // Запрашиваем у пользователя ввод значений x
        while (x == null) {
            System.out.print("Введите первое натуральное число (x): ");
            int xValue = scanner.nextInt(); // Читаем значение из ввода
            try {
                x = new NaturalNumber(xValue); // Пытаемся создать объект NaturalNumber
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Выводим ошибку, если значение некорректно
            }
        }

        // Запрашиваем у пользователя ввод значений y
        while (y == null) {
            System.out.print("Введите второе натуральное число (y): ");
            int yValue = scanner.nextInt(); // Читаем значение из ввода
            try {
                y = new NaturalNumber(yValue); // Пытаемся создать объект NaturalNumber
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Выводим ошибку, если значение некорректно
            }
        }

        // Выполняем проверку с введенными пользователем числами
        checkInduction(x, y);

        scanner.close(); // Освобождаем ресурсы, связанные со сканером
    }
}
