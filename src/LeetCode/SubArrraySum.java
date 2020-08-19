package LeetCode;

/**
 * created by suhail.jahangir on 16/08/20
 */
public class SubArrraySum {

    static class Solution {
        public int subarraySum(int[] nums, int k) {

            int len =nums.length;
            if(len ==0){
                return 0;
            }
            int j=0;
            int count =0;

            int sum =0;
            int i=0;
            while(i<len){
                sum = sum+nums[i];
                if(sum == k){
                    count++;
                    i++;
                    sum-=nums[j];

                    j++;
                } else if(sum>k){
                    sum-=nums[j];
                    j++;
                } else if(sum <k){
                    sum+=nums[i];
                    i++;
                }
            }
            return count;
        }
    }
}
