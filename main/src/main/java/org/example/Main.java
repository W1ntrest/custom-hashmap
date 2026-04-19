package org.example;

public class Main {
    static void main() {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.put("514", "a1");
        map.put("-123", "a2");
        map.put("32", "a3");
        map.put("16", "a4");

        CustomHashMap<Integer, String> map2 = new CustomHashMap<>();
        map2.put(514, "a1");
        map2.put(-123, "a2");
        map2.put(32, "a3");
        map2.put(16, "a4");
    }
}
