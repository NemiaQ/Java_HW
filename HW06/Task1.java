package HW06;

import java.util.*;

/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */

public class Task1 {
    public static void main(String[] args) {
        Notebook[] notebooks = new Notebook[]{
                new Notebook("Maibenben X558", 15.6, new Integer[]{1920, 1080}, 16, 512, 84999),
                new Notebook("MSI Katana GF76", 17.3, new Integer[]{1920, 1080}, 16, 256, 107899),
                new Notebook("Lenovo IdeaPad Gaming 3 15ACH6", 15.6, new Integer[]{1920, 1080}, 8, 512, 72999),
                new Notebook("Acer Nitro 5 AN515-46-R7XU", 15.6, new Integer[]{1920, 1080}, 16, 512, 74999),
                new Notebook("MSI GF63 Thin 11UC-218XRU", 15.6, new Integer[]{1920, 1080}, 8, 512, 85999),
        };

        Scanner scanner = new Scanner(System.in);

        Notebook lookingForNotebook = getRequestedNotebook(scanner);
        System.out.println("Поиск по следующим параметрам: \n\t" + lookingForNotebook);
        ArrayList<Notebook> getFiltered = getFiltered(lookingForNotebook, notebooks);
        showFiltered(getFiltered);
    }


    static Notebook getRequestedNotebook(Scanner scanner) {
        System.out.println("Укажите минимальные значение параметров для поиска (если параметр не важен, оставьте пустой ввод):");
        return new Notebook(
                (String) getInput("Бренд: ", "str", scanner),
                (Double) getInput("Размер экрана (в дюймах): ", "double", scanner),
                (Integer[]) getInput("Разрешение экрана (например, 1920х1080): ", "resolution", scanner),
                (Integer) getInput("RAM:", "int", scanner),
                (Integer) getInput("SSD >: ", "int", scanner),
                (Integer) getInput("Цена (минимум) >: ", "int", scanner)
        );
    }

    static ArrayList<Notebook> getFiltered(Notebook lookingForNotebook, Notebook[] notebooks) {
        ArrayList<Notebook> requestResult = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            if (notebook.compareTo(lookingForNotebook)) {
                requestResult.add(notebook);
            }
        }
        return requestResult;
    }


    static void showFiltered(ArrayList<Notebook> requestResult) {
        if (requestResult.size() == 0) {
            System.out.println("По данным критериям нет подходящих ноутбуков.");
        } else {
            System.out.println("Найдены следующие модели: ");
            for (int i = 0; i < requestResult.size(); i++) {
                System.out.printf("\t%d. %s.\n", i + 1, requestResult.get(i).toString());
            }
        }
    }


    static Object getInput(String msg, String objType, Scanner scanner) {
        while (true) {
            objType = objType.toLowerCase();
            System.out.print("\t" + msg);
            String input = scanner.nextLine();
            if (input.length() == 0 && objType.equals("resolution")) return new Integer[]{null, null};
            if (input.length() == 0) return null;
            switch (objType) {
                case "int" -> {
                    try {
                        int res = Integer.parseInt(input);
                        if (res > 0) return res;
                        else
                            System.out.println("Ошибка. Введите целое положительное число.");
                    } catch (Exception e) {
                        System.out.println("Ошибка. Введите целое положительное число.");
                    }
                }
                case "double" -> {
                    try {
                        double res = Double.parseDouble(input);
                        if (res > 0) return res;
                        else
                            System.out.println("Ошибка. Введите положительное число.");
                    } catch (Exception e) {
                        System.out.println("Ошибка. Введите положительное число.");
                    }
                }
                case "resolution" -> {
                    try {
                        String[] resStr = input.toLowerCase().replaceAll(" ", "").replace('x', ' ').replace('х', ' ').split(" ");
                        if (resStr.length == 2) {
                            Integer[] resArr = new Integer[2];
                            resArr[0] = Integer.parseInt(resStr[0]);
                            resArr[1] = Integer.parseInt(resStr[1]);
                            return resArr;
                        } else {
                            System.out.println("Ошибка. Неверный формат (например, 1920x1080)");

                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка. Неверный формат (например, 1920x1080)");
                    }
                }
                case "str" -> {
                    return input;
                }
                default -> System.out.println("Что-то пошло не так.");
            }
        }
    }
}