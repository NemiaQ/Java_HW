package HW01;

// Вывести все простые числа от 1 до 1000
public class Task2 {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {    // начала с 2, т.к. 1 не является простым числом
            simple(i);
        }
    }

    public static void simple(int n) {
        boolean flag = false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.print(n + ";");
        }
    }
}
