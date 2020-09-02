package LeetCode.august;

/**
 * created by suhail.jahangir on 22/08/20
 */
public class SortArrayByParity {

    static class Solution {
        public int[] sortArrayByParity(int[] num) {
            int j= num.length-1;
//            while(num)
            int len = num.length-1;
            int tmp;
            for (int i = 0; i < len; i++) {
                if ((num[i]&1) == 1){
                    while((num[len]&1) !=1){
                        len --;
                    }
                    tmp = num[i];
                    num[i] = num[len];
                    num[len] = tmp;
                }
            }
            return num;
        }
    }
}
