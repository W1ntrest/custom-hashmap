package org.example;

public class Main {
    static void main() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(8);

        map.put(2, "Element 5342");
        map.put(8, "Element 342");
        map.put(9, "Element 543");
        map.put(3, "Element 2112");
        map.put(1, "Element 512");
        map.put(4, "Element 5533");
        map.put(12, "Element 5325");
        map.put(5, "Element 4364");
        map.put(11, "Element 5435");
        map.put(7, "Element 111");
        map.put(6, "Element 7543");
        map.put(10, "Element 4124");

        System.out.println("Весь список HashMap");
        for (CustomHashMap.Node<Integer, String> node : map)
            System.out.println(node);

        System.out.println();
        System.out.println("Получить значение по ключу 7: " + map.get(7));
        System.out.println("Получить значение по ключу 4: " + map.get(4));
        System.out.println("Получить значение по ключу 11: " + map.get(11));
        System.out.println("Получить значение по ключу 15: " + map.get(15));
        System.out.println("Получить значение по ключу 67: " + map.get(67));

        System.out.println();
        System.out.println("Удалить элемент по ключу 3: " + map.remove(3));
        System.out.println("Удалить элемент по ключу 6: " + map.remove(6));
        System.out.println("Удалить элемент по ключу 9: " + map.remove(9));
        System.out.println("Удалить элемент по ключу 20: " + map.remove(20));
        System.out.println("Удалить элемент по ключу 32: " + map.remove(32));

        System.out.println();
        System.out.println("Полученный список");
        for (CustomHashMap.Node<Integer, String> node : map)
            System.out.println(node);

        System.out.println();
        System.out.println("Другие методы");
        System.out.println("containsKey(1): " + map.containsKey(1));
        System.out.println("containsKey(5): " + map.containsKey(5));
        System.out.println("containsKey(17): " + map.containsKey(17));

        System.out.println();
        System.out.println("containsValue(\"Element 111\"): " + map.containsValue("Element 111"));
        System.out.println("containsValue(\"Element 5533\"): " + map.containsValue("Element 5533"));
        System.out.println("containsValue(\"5423\"): " + map.containsValue("5423"));


        map.clear();

        System.out.println();
        System.out.println("Список после метода clear()");
        for (CustomHashMap.Node<Integer, String> node : map)
            System.out.println(node);
    }
}
