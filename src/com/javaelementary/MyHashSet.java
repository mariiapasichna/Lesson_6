package com.javaelementary;

import java.util.Arrays;

public class MyHashSet implements MySet {
    private MyHashMap map = new MyHashMap();
    private final String PLACEHOLDER = "";

    /**
     * Adds the specified element to this set if it is not already present.
     * If this set already contains the element, the call leaves the set unchanged and returns false.
     * @param e - element to be added to this set
     * @return true if this set did not already contain the specified element.
     */
    @Override
    public boolean add(String e) {
        map.put(e, PLACEHOLDER);
        return false;
    }

    /**
     * Removes all of the elements from this set. The set will be empty after this call returns.
     */
    @Override
    public void clear() {
        map.clear();
    }

    /**
     * Returns true if this set contains the specified element.
     * @param o - element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(String o) {
        return map.containsKey(o);
    }

    /**
     * Returns true if this set contains no elements.
     * @return true if this set contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Removes the specified element from this set if it is present.
     * @param o - object to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    @Override
    public boolean remove(String o) {
        map.remove(o);
        return true;
    }

    /**
     * Returns the number of elements in this set.
     * @return the number of elements in this set.
     */
    @Override
    public int size() {
        return map.size();
    }

    /**
     * Returns an array containing all of the elements in this collection.
     * @return an array containing all of the elements in this collection.
     */
    @Override
    public String[] toArray() {
        String[] result = new String[map.size()];
        int index = 0;
        for (MyMap.Entry entry : map.toArray()) {
            result[index++] = entry.getKey();
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}