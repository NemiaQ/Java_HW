//1.Реализовать алгоритм сортировки слиянием

package HW03;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] myArray = new int[]{8, 5, 2, 9, 1, 4, 6, 3, 7, 10};
        sort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void sort(int[] array) {
        if (array.length <= 1) return;

        int middle = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, middle);
        sort(left);

        int[] right = Arrays.copyOfRange(array, middle, array.length);
        sort(right);
        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] array) {
        int indexL = 0;
        int indexR = 0;
        int indexTarget = 0;

        while (indexL < left.length && indexR < right.length) {
            if (left[indexL] < right[indexR]) {
                array[indexTarget++] = left[indexL++];
            } else {
                array[indexTarget++] = right[indexR++];
            }
        }

        while (indexL < left.length) {
            array[indexTarget++] = left[indexL++];
        }
        while (indexR < right.length) {
            array[indexTarget++] = right[indexR++];
        }
    }
}