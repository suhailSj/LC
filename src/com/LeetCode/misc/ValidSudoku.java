package com.LeetCode.misc;

/**
 * created by suhail.jahangir on 26/09/20
 */

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */
public class ValidSudoku {

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            for(int i =0;i<9;i++){
                if(!checkForColumn(i, board)){
                    return false;
                }
                if(!checkForRow(i, board)){
                    return false;
                }
                if(!checkForBlock(i, board)){
                    return false;
                }
            }
            return true;
        }

        private boolean checkForBlock(int k, char[][] board) {
            boolean[] arr = new boolean[9];
            if(k<3){
                int s = k*3;
                for(int i=0;i<3;i++){
                    for(int j=s;j<s+3; j++){
                        if(board[i][j] != '.'){
                            if (!arr[board[i][j] -'0']) {
                                arr[board[i][j]-'0'] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            } else if(k<6){
                int s = (k%3)*3;
                for(int i=3;i<6;i++){
                    for(int j=s;j<s+3; j++){
                        if(board[i][j] != '.'){
                            if (!arr[board[i][j] -'0']) {
                                arr[board[i][j]-'0'] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            } else {
                int s = (k%3)*3;
                for(int i=6;i<9;i++){
                    for(int j=s;j<s+3; j++){
                        if(board[i][j] != '.'){
                            if (!arr[board[i][j] -'0']) {
                                arr[board[i][j]-'0'] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

        private boolean checkForRow(int k, char[][] board) {
            boolean[] arr = new boolean[9];
            for(int i=0; i<9;i++){
                if (row(i, board, arr, k)) return false;
            }
            return true;
        }

        private boolean checkForColumn(int k, char[][] board) {
            boolean[] arr = new boolean[9];
            for(int i=0; i<9;i++){
                if (row(k, board, arr, i)) return false;
            }
            return true;
        }

        private boolean row(int k, char[][] board, boolean[] arr, int i) {
            if(board[k][i] == '.'){
                return false;
            }
            if (!arr[board[k][i]-'0']) {
                arr[board[k][i]-'0'] = true;
            } else {
                return true;
            }
            return false;
        }
    }
}
