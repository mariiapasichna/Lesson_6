package com.javaelementary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyHashMap implements MyMap {

    private static class Entry implements MyMap.Entry {
        private String key;
        private String value;
        private Entry next;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            String oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private int size = 0;
    private Entry[] table = new Entry[16];
    private double loadFactor = 0.75;
    private int threshold = (int) (loadFactor * table.length);

    /**
     * Removes all of the mappings from this map. The map will be empty after this call returns.
     */
    @Override
    public void clear() {
        size = 0;
        table = new Entry[16];
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     * @param key - the key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key.
     */
    @Override
    public boolean containsKey(String key) {
        int index = Math.abs(key.hashCode()) % table.length;
        Entry tmpEntry = table[index];
        while (tmpEntry != null) {
            if (tmpEntry.key.equals(key)) {
                return true;
            }
            tmpEntry = tmpEntry.next;
        }
        return false;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     * @param key - the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    @Override
    public String get(String key) {
        int index = Math.abs(key.hashCode()) % table.length;
        Entry tmpEntry = table[index];
        while (tmpEntry != null) {
            if (tmpEntry.key.equals(key)) {
                return tmpEntry.value;
            }
            tmpEntry = tmpEntry.next;
        }
        return null;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if this map contains no key-value mappings.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * @param key - key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public String remove(String key) {
        int index = Math.abs(key.hashCode()) % table.length;
        Entry tmpEntry = table[index];
        if (tmpEntry.key.equals(key)){
            String result = tmpEntry.value;
            table[index] = tmpEntry.next;
            size--;
            return result;
        } else {
            while (tmpEntry != null) {
                if (tmpEntry.key.equals(key)) {
                    String result = tmpEntry.value;
                    table[index].next = tmpEntry.next;
                    size--;
                    return result;
                }
                tmpEntry = tmpEntry.next;
            }
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     * @param key   - key with which the specified value is to be associated
     * @param value - value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public String put(String key, String value) {
        if (size > threshold) {
            resize();
        }
        String result = putInternal(key, value);
        if (result==null){
            size++;
        }
        return result;
    }

    /**
     * Returns the number of key-value mappings in this map.
     * @return the number of key-value mappings in this map.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a Set view of the mappings contained in this map.
     * @return a set view of the mappings contained in this map.
     */
    @Override
    public Set<MyMap.Entry> entrySet() {
        Set<MyMap.Entry> result = new HashSet<>();
        for (Entry entry : table) {
            Entry tmpEntry = entry;
            while (tmpEntry != null) {
                result.add(tmpEntry);
                tmpEntry = tmpEntry.next;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    public Entry[] toArray() {
        Entry[] result = new Entry[size];
        int index = 0;
        for (Entry entry : table) {
            Entry tmpEntry = entry;
            while (tmpEntry != null) {
                result[index++] = tmpEntry;
                tmpEntry = tmpEntry.next;
            }
        }
        return result;
    }

    private String putInternal(String key, String value) {
        Entry newEntry = new Entry(key, value);
        int index = Math.abs(key.hashCode()) % table.length;
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry tmp = table[index];
            Entry oldEntry = table[index];
            while (oldEntry != null) {
                if (oldEntry.key.equals(newEntry.key)) {
                    String oldValue = oldEntry.value;
                    oldEntry.value = newEntry.value;
                    return oldValue;
                }
                oldEntry = oldEntry.next;
            }
            table[index] = newEntry;
            newEntry.next = tmp;
        }
        return null;
    }

    private void resize() {
        Entry[] arr = toArray();
        table = new Entry[table.length * 2];
        threshold = (int) (table.length * loadFactor);
        for (Entry entry : arr) {
            putInternal(entry.getKey(), entry.getValue());
        }
    }
}