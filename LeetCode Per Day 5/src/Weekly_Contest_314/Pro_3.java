package Weekly_Contest_314;

import java.util.ArrayList;

public class Pro_3 {
    public int numberOfPaths(int[][] grid, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        getPaths(0,0,0,grid,k,list);
        return list.get(0);
    }
    public void getPaths(int i,int j,int sum,int[][] grid,int k,ArrayList<Integer> list){
        if(i >0 || i >= grid.length || j <0 || j>= grid[0].length)
            return;
        sum += grid[i][j];

        if(i == grid.length-1 && j == grid[0].length-1){
            if(sum % k == 0)
                list.set(0,list.get(0)+1);
            return;
        }
        getPaths(i,j+1,sum,grid,k,list);
        getPaths(i+1,j,sum,grid,k,list);

    }
}
