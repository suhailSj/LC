package com.LeetCode.May;

public class FirstBadVersiom {
    static boolean[] bad;
    static int count =0;
    public static void main(String... a) {
        bad = new boolean[]{false, false, false, true, true};
        Solution sol = new Solution();
        System.out.println(sol.firstBadVersion(5));
        System.out.println("count - "+count);

    }

    public static class Solution extends FirstBadVersiom {
        public int firstBadVersion(int n) {
            boolean[] arr = new boolean[n+1];
            boolean[] visited = new boolean[n+1];
           return getBad(0,n);
        }
        public int getBad(int start, int last ) {
            int mid=0;
            if(last>=1) {
                mid  = (last-1+start)/2 +1;
            }

            if(isBadVersion(mid)){
                if(!isBadVersion(mid -1)) {
                    return mid;
                }
               return getBad(start, mid);
            }else {
               return getBad(mid, last);
            }
        }
    }
    public boolean isBadVersion(int n) {
        count++;
        return bad[n];
    }
}
