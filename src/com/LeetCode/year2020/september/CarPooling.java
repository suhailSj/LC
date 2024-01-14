package com.LeetCode.year2020.september;

/**
 * created by suhail.jahangir on 21/09/20
 */

import java.util.PriorityQueue;

/**
 * You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)
 *
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.
 *
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 * Example 1:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 * Example 3:
 *
 * Input: trips = [[2,1,5],[3,5,7]], capacity = 3
 * Output: true
 * Example 4:
 *
 * Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * Output: true
 */
public class CarPooling {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.carPooling(new int[][]{
                {3,2,7},
                {3,7,9},
                {8,3,9}
        },11));
        System.out.println(sol.carPooling(new int[][]{
                {2,1,5},
                {3,5,7}
        },5));
        System.out.println(sol.carPooling(new int[][]{
                {2,1,5},
                {3,3,7}
        },4));
        System.out.println(sol.carPooling(new int[][]{
                {2,1,5},
                {3,3,7}
        },5));
    }
    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            PriorityQueue<Passenger> list = new PriorityQueue<>((a,b) -> {
                if(a.position == b.position){
                    if(!a.boarding){
                        return -1;
                    }if(!b.boarding){
                        return 1;
                    }
                    return 0;
                }
                return a.position - b.position;
            });
            for(int i = 0; i< trips.length; i++){
                list.add(new Passenger(trips[i][0],trips[i][1],true));
                list.add(new Passenger(trips[i][0],trips[i][2],false));
            }
            int currentCapacity = 0;
            while(!list.isEmpty()) {
                Passenger p = list.remove();
                if(p.boarding){
                    currentCapacity += p.num;
                }else{
                    currentCapacity -= p.num;
                }
                if(currentCapacity > capacity){
                    return false;
                }
            }
            return true;
        }

        static class Passenger{
            public int num;
            public int position;
            public boolean boarding;

            public Passenger(int num, int position, boolean boarding){
                this.num = num;
                this.position = position;
                this.boarding = boarding;
            }
        }
    }
}
