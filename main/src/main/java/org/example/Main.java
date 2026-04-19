package org.example;

public class Main {
    static void main() {
        CustomHashMap<String, String> map = new CustomHashMap<>(4);
        map.put("514", "a1");
        map.put("-123", "a2");
        map.put("32", "a3");
        map.put("16", "a4");
        map.put("543", "a5");
        map.put("222", "a6");
        map.put("967", "a7");
        map.put("755", "a8");
        map.put("323", "a9");
        map.put("574", "a10");
        map.put("231", "a11");
        map.put("111", "a12");

        map.remove("-123");

        CustomHashMap<Integer, String> map2 = new CustomHashMap<>(4);
        map2.put(514, "a1");
        map2.put(-123, "a2");
        map2.put(32, "a3");
        map2.put(16, "a4");

        System.out.println(map2.get(514));

        System.out.println(map2.get(-123));
        System.out.println(map2.get(123));

        System.out.println(map2.get(32));
        System.out.println(map2.get(16));

    }
}
