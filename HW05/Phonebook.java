package HW05;

import java.util.LinkedList;
import java.util.TreeMap;

public class Phonebook {
    TreeMap<String, LinkedList<Integer>> phonebook = new TreeMap<>();

    void add(String name, int number){
        if (phonebook.containsKey(name)){
            phonebook.get(name).add(number);
        }else {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(number);
            phonebook.put(name,list);
        }
    }

    void showName(String name){
        if (phonebook.containsKey(name)){
            System.out.printf("С именем \"%s\" найдены следующие записи: \n", name);
            int count = 0;
            for (int number : phonebook.get(name)){
                System.out.printf("\t%d. %d\n", ++count, number);
            }
          System.out.println("______________________________");
        }else {
            System.out.printf("Имя \"%s\" в телефонной книге не найдено.%n", name);
        }
    }

    void showAll(){
        if (!phonebook.isEmpty()){
            System.out.println("____Весь справочник:____");
            for (String name : phonebook.keySet()) {
                System.out.println(name + ":");
                int count = 0;
                for (int number : phonebook.get(name)){
                    System.out.printf("\t%d. %d\n", ++count, number);
                }
            }
            System.out.println("______________________________");
        }else {
            System.out.println("Телефонный справочник пуст.");
        }
    }
}