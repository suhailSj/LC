package com.LeetCode.august;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * created by suhail.jahangir on 23/08/20
 */
public class NonOverlappingRectangles {



    static  class Solution {

        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        int[][] rect =null;
        Random r = new Random();
        public Solution(int[][] rects) {
            rect = rects;
//            for(int i=0;i<rects.length; i++){
//
//            }
        }

        public int[] pick() {
            int k = r.nextInt(rect.length);

            return getNum(k);
        }
        public int[] getNum(int k){
            int x=r.nextInt(rect[k][2]-rect[k][0]+1)+rect[k][0];
            int y=r.nextInt(rect[k][3]-rect[k][1]+1)+rect[k][1];
            if(map.containsKey(k)){
                HashSet<String> set = map.get(k);
                if(set.contains(x+","+y)){
                    return getNum(k);
                } else{
                    set.add(x+","+y);
                    map.put(k,set);
                }
            }
            return new int[]{x,y};
        }
    }

//    static
//    class Solution {
//        int[][] rect;
//        TreeMap<Integer,Integer> tm=new TreeMap<>();
//        int sum=0;
//        Random ran=new Random();
//        public Solution(int[][] rects) {
//            rect=rects;
//            for(int k=0;k<rects.length;k++){
//                sum+=(rect[k][2]-rect[k][0]+1)*(rect[k][3]-rect[k][1]+1);
//                tm.put(sum,k);
//            }
//        }
//        public int[] pick() {
//
//            int k=tm.get(tm.ceilingKey(ran.nextInt(sum+1)));        // sum can also be picked
//            int x=ran.nextInt(rect[k][2]-rect[k][0]+1)+rect[k][0];
//            int y=ran.nextInt(rect[k][3]-rect[k][1]+1)+rect[k][1];
//            return new int[]{x,y};
//        }
//    }
}
