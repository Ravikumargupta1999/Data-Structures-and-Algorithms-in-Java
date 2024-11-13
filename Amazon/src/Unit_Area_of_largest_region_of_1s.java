import java.util.Map;

// https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1/?company[]=Amazon&company[]=Amazon&page=1&category[]=Graph&query=company[]Amazonpage1company[]Amazoncategory[]Graph#

public class Unit_Area_of_largest_region_of_1s {
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int maxLength = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] ==1) {
//                    System.out.println(" Hello ");
                    maxLength = Math.max(maxLength, maxRegion(grid, row, col));
                }
            }
        }
        return maxLength;
    }

    public int maxRegion(int[][] grid, int row, int col) {
//        System.out.println(" Hello 1");
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length)
            return 0;
        if (grid[row][col] == 0)
            return 0;
        grid[row][col] = 0;
        int length = 1;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r != row || c != col)
                    length += maxRegion(grid, r, c);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}};
        Unit_Area_of_largest_region_of_1s a = new Unit_Area_of_largest_region_of_1s();
        System.out.println(a.findMaxArea(grid));
    }
}
