/*Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут 
повторяющиеся имена с разными телефонами, их необходимо считать, как 
одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.*/

import java.util.*;

public class Task1 {
    public static void phone_book() {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Alexey", "+79216579200");
        addContact(phoneBook, "Yulia", "+79110984521");
        addContact(phoneBook, "Andrey", "+79049871037");
        addContact(phoneBook, "Oxana", "+79001239854");
        addContact(phoneBook, "Yana", "+79538758394");
        addContact(phoneBook, "Maxim", "+79056273722");
        addContact(phoneBook, "Andrey", "+79215463481");


        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        }
    }

    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {

        if (phoneBook.containsKey(name)) {
            Set<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {

            Set<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
}