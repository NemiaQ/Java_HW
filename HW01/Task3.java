//Реализовать простой калькулятор
package HW01;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введи первое число: ");
        double a = iScanner.nextInt();
        System.out.print("Введи операцию +, -, *, /: ");
        String operation = iScanner.next();
        System.out.print("Введи второе число: ");
        double b = iScanner.nextInt();
        iScanner.close();

        double result = calc(a, b, operation);
        System.out.printf("%.2f %s %.2f = %.2f", a, operation, b, result);
    }

    public static double calc(double a, double b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                System.out.println("Ошибка ввода.");
                return 0;
        }
    }
}
