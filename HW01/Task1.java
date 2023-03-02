//Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
//        (произведение чисел от 1 до n)

package HW01;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner iScaner = new Scanner(System.in);
        System.out.println("Введите число больше 0: ");
        int n = iScaner.nextInt();
        iScaner.close();

        int triangle = n * (n + 1) / 2;
        int factorial = factorial(n);

        System.out.printf("%d-е треугольное число = %d", n, triangle);
        System.out.println();
        System.out.printf("Прозведение чисел от 1 до %d = %d", n, factorial);
    }

    public static int factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return n * factorial(n - 1);
        }
    }
}
