package LeetCode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String... a) {
        Solution sol = new Solution();
        sol.spiralOrder(null);
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int leftBegin =0;
            int rightEnd = matrix.length-1;
            int down = matrix[0].length;
//            List<Integer> list = new ArrayList<>();
//            while(true){
//                for(int i=leftBegin; i<=rightEnd; i++){
//                    list.add(matrix[leftBegin][i]);
//                }
//                for(int i=leftBegin+1; i<down; i++){
//                    list.add(matrix[i][rightEnd);
//                }
//            }
            return null;
        }
    }

    public String multiply(String num1, String num2) {
        BigInteger bd = new BigInteger(num1);
        return (""+(bd.multiply(new BigInteger(num2))));
    }
}
