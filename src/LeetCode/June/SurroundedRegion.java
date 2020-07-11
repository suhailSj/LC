package LeetCode.June;

public class SurroundedRegion {

    public static void main(String... a){
        Solution sol = new Solution();
        //[["X","O","X","X"],["X","X","X","X"],["X","O","O","X"],["X","O","X","X"]]
        //[["O","X","X","X","X","X","O","O"],["O","O","O","X","X","X","X","O"],["X","X","X","X","O","O","O","O"],["X","O","X","O","O","X","X","X"],["O","X","O","X","X","X","O","O"],["O","X","X","O","O","X","X","O"],["O","X","O","X","X","X","O","O"],["O","X","X","X","X","O","X","X"]]
        //[["X","O","X","O","X","O"],["O","X","O","X","O","X"],["X","O","X","O","X","O"],["O","X","O","X","O","X"]]
        char[][] arr = new char[][]{{'X', 'O', 'X', 'O','X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O','X', 'O', 'X', 'O'}, {'O','X', 'O', 'X', 'O','X'}};
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
        sol.solve(arr);
        System.out.println();
        System.out.println();
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }


    static class Solution {
        public void solve(char[][] board) {

            boolean[][] visited = new boolean[board.length][board[0].length];
// 1  2 3 4 5
// 5  4 7 8 9
            for(int i=0;i<board[0].length; i++) {
                dfs(0, i, board, visited);//0,1   0,2   0,3
                dfs(board.length-1, i, board, visited);// 4,0   4,1, 4,3
            }

            for(int i=0; i< board.length; i++){
                dfs(i, 0, board, visited);//0,0    1,0    2,0   3,0
                dfs(  i, board[0].length-1, board, visited);// 0,5      1,5     2,5
            }


        // 2 5

            for(int i=0; i<board.length; i++){
                for(int j=0; j< board[0].length; j++){
                    if(board[i][j] == 'P'){
                        board[i][j] = 'O';
                    } else{
                        board[i][j] ='X';
                    }
                }
            }
        }

        public void dfs(int i, int j, char[][] board, boolean[][] visited) {
            if(i<0 || j < 0 || i>=board.length || j >= board[0].length || visited[i][j]) {
                return;
            }
            visited[i][j] = true;
            if(board[i][j] =='O' || board[i][j] == 'P') {
                board[i][j] = 'P';
                dfs(i+1, j, board, visited);
                dfs(i, j+1, board, visited);
                dfs(i-1, j, board, visited);
                dfs(i, j-1, board, visited);
            }
        }







        public boolean checkForBorder(int i, int j, char[][] board, int start){
            if(board[i][j] == 'X'){
                return false;
            }
            if(start ==0){
                return (checkForBorder(i-1, j, board, 1) ||
                        checkForBorder(i, j-1, board, 1) ||
                        checkForBorder(i+1, j, board, 2) ||
                        checkForBorder(i, j+1, board, 2) );
            }else if(start == 1){
                //&& (i==0 || j==0||i==board.length-1||j ==board[0].length)
                if(i==0) {
                    if(board[i][j] == 'O' ){
                        return true;
                    } else {
                        return false;
                    }
                }
                if(board[i][j] == 'O' ){
                    return true;
                }
                return false;
            } else if(start == 3) {
                if(j==0) {
                    if(board[i][j] == 'O' ){
                        return true;
                    } else {
                        return false;
                    }
                }
                if(board[i][j] == 'O' ){
                    return checkForBorder(i-1, j, board, 3);
                }
                return false;
            }

            if(i<board.length && j <board[0].length && board[i][j] == 'O'){
                if(i==board.length-1||j ==board[0].length-1){
                    return true;
                }
                return (checkForBorder(i+1, j, board, 2) || checkForBorder(i, j+1, board, 2) || checkForBorder(i, j-1, board, 3)|| checkForBorder(i-1, j, board, 1));
            }
            return false;


        }
    }
}
