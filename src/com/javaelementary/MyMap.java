package com.javaelementary;

import java.util.Set;

public interface MyMap {
    interface Entry {
        String getKey();

        String getValue();

        String setValue(String value);
    }

    void clear();

    boolean containsKey(String key);

    String get(String key);

    boolean isEmpty();

    String remove(String key);

    String put(String key, String value);

    int size();

    Set<Entry> entrySet();
}