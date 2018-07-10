package ru.geekbrains.Dz.Dz3;

import java.util.*;

public class Array {
    //    Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
//вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//Посчитать, сколько раз встречается каждое слово.
    public static void main(String[] args) {
        String[] word = {"Наверное", "каждый", "программист", "знает", "или", "хотя", "бы",
                "слышал", "про", "регулярные", "выражения", "Наверное", "программист", "знает",};

        LinkedHashSet<String> hs = new LinkedHashSet<>();

        for (String s : word) {
            hs.add(s);
        }
        System.out.println(hs);
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < word.length; i++) {
            Integer res = hm.get(word[i]);
            hm.put(word[i], res == null ? 1 : res + 1);
        }
        System.out.println(hm);
    }

}




