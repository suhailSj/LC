package LeetCode.september;

import java.util.*;

/**
 * created by suhail.jahangir on 02/09/20
 */
public class ContainsDuplicate {

    public static void main(String... a){
        Solution sol = new Solution();
        sol.containsNearbyAlmostDuplicate(new int[]{1,2,3,4,1}, 3, 0);
    }


    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (t < 0) {
                return false;
            }

            // sliding window
            ArrayList<Long> queue = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {


                queue.add((long) nums[i]);
                if(queue.size() > k+1){
                    queue.remove((long) nums[i - k-1]);
                }
                if (queue.size() == k+1) {
                    if (containsDuplicate(queue, k, t)) {
                        return true;
                    }

                }
            }
            return false;
        }

        public boolean containsDuplicate(ArrayList<Long> set, int k, int t){
            if(set.isEmpty()){
                return false;
            }
            Collections.sort(set);
            Long prev = null;
            for(Long i : set){
                if(prev == null){
                    prev = i;
                    continue;
                }
                if((i - prev) <= t){
                    return true;
                }
                prev = i;
            }
            return false;
        }
    }

}
