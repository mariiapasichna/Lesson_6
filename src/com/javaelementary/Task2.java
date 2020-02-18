package com.javaelementary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task2 {

    /*
    2*) Реализовать MyHashMap и MayHashSet
    */

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "asdf");
        map.put("2", "qwert");
        map.put("3", "zxcv");
        map.put("1", "zzz");
        System.out.println(map);
        MyMap myMap = new MyHashMap();
        myMap.put("1", "asdf");
        myMap.put("2", "qwert");
        myMap.put("3", "zxcv");
        myMap.put("1", "zzz");
        System.out.println(myMap);
        System.out.println(map.get("2"));
        System.out.println(myMap.get("2"));
        System.out.println(map.containsKey("3"));
        System.out.println(myMap.containsKey("3"));
        System.out.println(map.isEmpty());
        System.out.println(myMap.isEmpty());
        System.out.println(map.remove("2"));
        System.out.println(myMap.remove("2"));
        System.out.println(map);
        System.out.println(myMap);
        System.out.println(map.size());
        System.out.println(myMap.size());
        System.out.println(map.entrySet());
        System.out.println(myMap.entrySet());

        Set<String> set = new HashSet<>();
        set.add("asdf");
        set.add("qwer");
        set.add("zxcv");
        set.add("asdf");
        System.out.println(set);
        MySet mySet = new MyHashSet();
        mySet.add("asdf");
        mySet.add("qwer");
        mySet.add("zxcv");
        mySet.add("asdf");
        System.out.println(mySet);
        System.out.println(set.contains("asdf"));
        System.out.println(mySet.contains("asdf"));
        System.out.println(set.isEmpty());
        System.out.println(mySet.isEmpty());
        System.out.println(set.remove("qwer"));
        System.out.println(mySet.remove("qwer"));
        System.out.println(set);
        System.out.println(mySet);
        System.out.println(set.size());
        System.out.println(mySet.size());
        set.clear();
        mySet.clear();
        System.out.println(set);
        System.out.println(mySet);
    }
}