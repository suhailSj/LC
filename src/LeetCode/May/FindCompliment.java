package LeetCode.May;

public class FindCompliment {

    public static void main(String... a) {
        Solution sol= new Solution();
        System.out.println( Math.ceil(Math.log10(2147483648l)/Math.log10(2)+0.0000000001));
        System.out.println(sol.findComplement(3));
    }


    static class Solution {
        public int findComplement(int num) {
            if(num ==1 || num == 2147483647){
                return 0;
            }
            long pow =(long) Math.ceil(Math.log10(num)/Math.log10(2)+0.0000000001);
            long max = (long) Math.pow(2, pow)-1;
            System.out.println("pow"+pow);
            System.out.println("max"+max);

            return (int) ((int)num^max);
        }
    }
}
