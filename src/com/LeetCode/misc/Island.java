package com.LeetCode.misc;

import java.util.LinkedList;
import java.util.Queue;

public class Island {

    public static void main(String...a ){
        Solution sol = new Solution();
        int[][] grid = {{1,0,0,1},
                        {0,1,1,0},
                        {0,1,1,1},
                        {1,0,1,1}};
        System.out.println(sol.findCircleNum(grid));
        //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]

    }
    public static class Solution {
        public int findCircleNum(int[][] grid) {
            return numberAmazonGoStores(grid.length, grid[0].length, grid);
        }
        public int numberAmazonGoStores(int rows, int column, int[][] grid)
        {
            Boolean[][] visited = new Boolean[rows][column];
            for(int i=0;i<rows; i++) {
                for(int j=0;j<column; j++) {
                    visited[i][j] = false;
                }
            }
            Queue<Dummy> queue = new LinkedList<>();
            int count = 0;
            for(int i=0; i< rows; i++) {

                for(int j=0; j<column; j++) {
                    if(!visited[i][j] && grid[i][j] == 1) {
                        queue.add(new Dummy(i,j));
                        while(!queue.isEmpty()){
                            isCluster(visited, queue, grid);
                        }
                        count++;
                    }
                }
            }
            return count;
        }

        public static class Dummy {
            public int i;
            public int j;
            public Dummy(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        public void isCluster(Boolean[][] visited, Queue<Dummy> queue, int[][] grid) {

            Dummy obj = queue.remove();
            int i= obj.i;
            int j= obj.j;
            if(visited[i][j]){
                return ;
            }
            visited[i][j] = true;
            if(i+1<grid.length && grid[i+1][j] == 1 && !visited[i+1][j]) {
                queue.add(new Dummy(i+1, j));
            }
            if(j+1 < grid[0].length && grid[i][j+1] == 1 && !visited[i][j+1]) {
                queue.add(new Dummy(i, j+1));
            }
            if(j-1 >= 0 && grid[i][j-1] == 1 && !visited[i][j-1]) {
                queue.add(new Dummy(i, j-1));
            }
            if(i-1>=0 && grid[i-1][j] == 1 && !visited[i-1][j]) {
                queue.add(new Dummy(i-1, j));
            }
            if(i-1>=0 && j-1 >= 0 && grid[i-1][j-1] == 1 && !visited[i-1][j-1]) {
                queue.add(new Dummy(i-1, j-1));
            }
            if(i-1>=0 &&  j+1 < grid[0].length && grid[i-1][j+1] == 1 && !visited[i-1][j+1]) {
                queue.add(new Dummy(i-1, j+1));
            }

            if(i+1<grid.length && j-1 >= 0&& grid[i+1][j-1] == 1 && !visited[i+1][j-1]) {
                queue.add(new Dummy(i+1, j-1));
            }


            if(i+1<grid.length && j+1 < grid[0].length && grid[i+1][j+1] == 1 && !visited[i+1][j+1]) {
                queue.add(new Dummy(i+1, j+1));
            }
        }
    }
}
