//2 . Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
package HW02;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Task2 {
    private static Logger logger;
    public static void main(String[] args) {
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("Task2_log.log", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SimpleFormatter sFormatter = new SimpleFormatter();
        fileHandler.setFormatter(sFormatter);
        logger = Logger.getLogger(Task2.class.getName());
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);

        int[] intArray = new int[]{2,6,8,4,10,7,3,9,5,1};
        System.out.println(Arrays.toString(intArray));

        sortArr(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    public static void sortArr(int[] arr) {
        logger.info(String.format("Начало сортировки. Массив %s.", Arrays.toString(arr)));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            logger.info(String.format("Итерация № %d, массив: %s", i + 1, Arrays.toString(arr)));
        }
        logger.info(String.format("""
                Конец сортировки. Итог: %s
                _____________________________________________________________
                """, Arrays.toString(arr)));
    }
}