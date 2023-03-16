package HW05;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

public class Task1 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.showAll();
        phonebook.add("Ирина", 12456);
        phonebook.add("Ирина", 456789);
        phonebook.add("Сергей", 995522);
        phonebook.add("Иван", 852369);
        phonebook.showAll();
        phonebook.showName("Ольга");
        phonebook.showName("Ирина");

    }
}