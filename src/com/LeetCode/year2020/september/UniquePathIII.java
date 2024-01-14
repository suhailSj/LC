package com.LeetCode.year2020.september;

/**
 * created by suhail.jahangir on 20/09/20
 */

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 *
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 *
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 */
public class UniquePathIII {

    static class Solution {
        public int uniquePathsIII(int[][] grid) {
            int x =0,y=0;
            int zeroCount =0;
            for(int i=0;i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j] == 0){
                        zeroCount++;
                    }
                    if(grid[i][j] == 1){
                        x=i;
                        y=j;
                    }
                }
            }
            return DFS(grid, zeroCount, x,y, -1);
        }

        private int DFS(int[][] grid, int zeroCount, int x, int y, int currCount) {
            if(x <0 || y < 0 || x>=grid.length || y>= grid[0].length || grid[x][y] == -1){
                return 0;
            }
            if(grid[x][y] == 2){
                if(currCount == zeroCount){
                    return 1;
                } else{
                    return 0;
                }
            }
            grid[x][y] = -1;
            int a = DFS(grid,zeroCount,x+1,y,currCount+1);
            int b = DFS(grid,zeroCount,x-1,y,currCount+1);
            int c = DFS(grid,zeroCount,x,y+1,currCount+1);
            int d = DFS(grid,zeroCount,x,y-1,currCount+1);
            grid[x][y] =0;
            return (a+b+c+d);
        }
    }
}
