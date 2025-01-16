//Nazarova Kseniia, 2024
package laba_1_ver2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueMoving = true;

        while (continueMoving) {
            Hero hero = new Hero();

            try {
                System.out.print("Введите расстояние (км, например, 5,5): ");
                double distance = scanner.nextDouble();
                scanner.nextLine();

                if (distance < 0) {
                    System.out.println("Ошибка: расстояние не может быть отрицательным.");
                    continue;
                }

                if (distance < 10) {
                    hero.setMovementStrategy(new Walk());
                } else if (distance < 30) {
                    hero.setMovementStrategy(new HorsebackRiding());
                } else {
                    hero.setMovementStrategy(new Flying());
                }

                hero.move(distance);

                String answer;
                while (true) {
                    System.out.print("Выполнить еще одно движение? (да/нет): ");
                    answer = scanner.nextLine().trim().toLowerCase();
                    if (answer.equals("да")) {
                        break;
                    } else if (answer.equals("нет")) {
                        continueMoving = false;
                        break;
                    } else {
                        System.out.println("Ошибка: пожалуйста, введите 'да' или 'нет'.");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Ошибка: пожалуйста, введите числовое значение.");
                scanner.nextLine();
            }
        }

        scanner.close(); 
    }
}
