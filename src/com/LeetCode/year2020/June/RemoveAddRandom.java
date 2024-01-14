package com.LeetCode.year2020.June;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveAddRandom {

    public static void main(String...a ){

    }

    static class RandomizedSet {

        /** Initialize your data structure here. */
        HashMap<Integer,Integer> map ;
        int[] arr ;
        int count ;
        public RandomizedSet() {
            map = new HashMap<>();
            count = 0;
            arr = new int[16];
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.put(val, count) == null){
                if(arr.length == count){
                    arr = Arrays.copyOf(arr, arr.length*2);
                }
                arr[count] = val;
                count++;
                return true;
            }else {
                return false;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            Integer key = map.remove(val);
            if(key == null){
                return false;
            }else {
                int tmp = arr[count];
                arr[key] = tmp;
                count--;
                map.put(tmp, key);
                return true;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int v = ((int) (Math.random() * 100000))%count;
            return arr[v];
        }
    }
}
