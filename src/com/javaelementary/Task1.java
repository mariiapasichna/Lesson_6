package com.javaelementary;

import java.util.ArrayList;
import java.util.List;

public class Task1 {

    /*
    1) Написать метод который принимает 2 строки - a, b. Метод должне вернуть количество символов которые у них различаются.
    Если строки разной длины то вернуть -1.
    Примеры:
    a="asdf", b="qwerty" => -1
    a="abb", b="bba" => 0
    a="abc", b="dca" => 1
    a="aaa", b="fga" => 2
    a="abc", b="dfg" => 3
    */

    public static void main(String[] args) {
        String a = "aaa";
        String b = "fga";
        System.out.println(returnNumberOfDifferentCharacters(a, b));
    }

    private static int returnNumberOfDifferentCharacters(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        } else {
            List<Character> listA = new ArrayList<>();
            List<Character> listB = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                listA.add(a.charAt(i));
                listB.add(b.charAt(i));
            }
            for (int i = 0; i < listB.size(); i++) {
                listA.remove(listB.get(i));
            }
            return listA.size();
        }
    }
}