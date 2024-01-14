package com.LeetCode.misc;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheImpl {

    public static void main(String... a){

    }

    static class LRUCache {

        LinkedList<Integer> list;
        HashMap<Integer, Integer> map;
        int size = 0;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new LinkedList<>();
            size = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }
            list.remove(key);
            list.addFirst(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if(map.size() == size){
                map.remove(list.removeLast());
                size --;
            }
            map.put(key,value);
            size++;
            list.addFirst(key);
        }
    }

}
