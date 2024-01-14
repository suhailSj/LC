package com.LeetCode.year2020.august;

import java.util.stream.IntStream;

/**
 * created by suhail.jahangir on 24/08/20
 */
public class DistributeCandies {
    public static void main(String... a){
        Solution s = new Solution();
        int[] as =s.distributeCandies(89, 3);

       for(int sd : as){
           System.out.print(sd+",");
       }
    }

    static class Solution {
        int[] ans;
        public int[] distributeCandies(int candies, int num) {
            ans = new int[num];
            int ap = (num * (num+1))/2;
            int pass = 0;
            int h = num;
            while(candies > ap && ap >0){
                pass++;
                candies -=ap;
                h*=h;
                ap=ap*(h);
            }
            fillWithPass(num, pass);

            //distribute(candies,1,num, pass*num+1);
            int val = pass*num;
            pass = pass*num+1;
            for(int i=0; i<num;i++){
                if(candies==0 || candies < val+i+1){
                    ans[i] +=candies;
                    return ans;
                }
                ans[i] +=  val+i+1;
                candies = candies - (val+i+1);
            }
            return ans;
        }
//
        private void fillWithPass(int num, int pass) {
            if(pass >0){

                if(pass>1){
                    for(int i=0;i<num; i++){
                        ans[i] = (i+1)*pass+pass*num;
                    }
                } else{
                    ans = IntStream.range(1,num+1).toArray();
                }
            }
        }

        private void distribute(int candies, int currPerson, int num, int pass) {
            if(currPerson > num){
                currPerson = 1;
            }
            if(candies==0 || candies < pass){
                ans[currPerson-1] +=candies;
                return;
            }
            ans[currPerson-1] +=pass;
            distribute(candies-pass,currPerson+1,num,pass+1);
        }
    }
}
