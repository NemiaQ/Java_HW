//2.Пусть дан произвольный список целых чисел, удалить из него четные числа

package HW03;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(8, 5, 2, 9, 1, 4, 6, 3, 7, 10));
        System.out.printf("Список: %s\n", numList);
        numList.removeIf(x -> x % 2 == 0);
        System.out.printf("Список нечетных чисел: %s", numList);
    }
}