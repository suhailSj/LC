package company.amazon;

import java.util.*;

public class Amazon {
    public static void main(String... a) {
        List<Integer> lis1 = Arrays.asList(1,1,0,0);
        List<Integer> lis2 = Arrays.asList(0,1,0,0);
        List<Integer> lis3 = Arrays.asList(0,0,1,0);
        List<Integer> lis4 = Arrays.asList(1,0,0,1);
        List<Integer> lis5 = Arrays.asList(1,1,1,1);
        List<List<Integer>> list = new ArrayList<>();
        list.add(lis1);
        list.add(lis2);
        list.add(lis3);
        list.add(lis4);
        list.add(lis5);
        Amazon amazon = new Amazon();
       System.out.println(amazon.numberAmazonGoStores(5, 4,list ));
    }
        int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid)
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
                    if(!visited[i][j] && grid.get(i).get(j) == 1) {
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

        public void isCluster(Boolean[][] visited, Queue<Dummy> queue, List<List<Integer> > grid) {

            Dummy obj = queue.remove();
            int i= obj.i;
            int j= obj.j;
            if(visited[i][j]){
                return ;
            }
            visited[i][j] = true;
            if(i+1<grid.size() && grid.get(i+1).get(j) == 1 && !visited[i+1][j]) {
                queue.add(new Dummy(i+1, j));
            }
            if(j+1 < grid.get(i).size() && grid.get(i).get(j+1) == 1 && !visited[i][j+1]) {
                queue.add(new Dummy(i, j+1));
            }
            if(j-1 > 0 && grid.get(i).get(j-1) == 1 && !visited[i][j-1]) {
                queue.add(new Dummy(i, j-1));
            }
            if(i-1>0 && grid.get(i-1).get(j) == 1 && !visited[i-1][j]) {
                queue.add(new Dummy(i-1, j));
            }
        }
        // METHOD SIGNATURE ENDS

}
