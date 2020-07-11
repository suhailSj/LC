//package LeetCode.June;
//
//public class PermutationSequence {
//
//    public static void main(String... a) {
//
//    }
//
//    static class Solution {
//        public String getPermutation(int n, int k) {
//            int[] fact = new int[n+1];
//            fact[0] = 1;
//            int[] arr = new int[n+1];
//            arr[0] = 0;
//            for(int i=1;i<=n; i++) {
//                fact[i] = fact[i-1] *i;
//                arr[i] = i;
//            }
//            if(k == fact[n]) {
//
//            }
//            int tmp = k;
//            int inc = 1;
//            int val = 1;
//            StringBuffer sb = new StringBuffer();
//            while(k > 1) {
//                if(k > fact[n-inc]) {
//                    val++;
//
//                    k = k-fact[n - inc];
//                } else{
//                    sb.append(arr[val]);
//                    arr[val] = -1;
//                    val =1;
//                    inc++;
//                }
//            }
//        }
//    }
//}
