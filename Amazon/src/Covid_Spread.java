public class Covid_Spread {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1, 1}, {0, 2, 1, 1, 1}};
//                {1, 0, 0, 2, 1}};
        Covid_Spread a = new Covid_Spread();
        System.out.println(a.helpaterp(arr));
    }

    int count = 0;

    public int helpaterp(int[][] hospital) {
        boolean[][] visited = new boolean[hospital.length][hospital[0].length];
        for (int i = 0; i < hospital.length; i++) {
            for (int j = 0; j < hospital[0].length; j++) {
                System.out.print(hospital[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
        for (int i = 0; i < hospital.length; i++) {
            for (int j = 0; j < hospital[0].length; j++) {
                System.out.print(visited[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");


        for (int i = 0; i < hospital.length; i++) {
            for (int j = 0; j < hospital[0].length; j++) {
                if (hospital[i][j] == 2 && visited[i][j] == false) {
                    count++;
                    explore(hospital, visited, i, j);
                }
            }
        }

        for (int i = 0; i < hospital.length; i++) {
            for (int j = 0; j < hospital[0].length; j++) {
                System.out.print(hospital[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
        for (int i = 0; i < hospital.length; i++) {
            for (int j = 0; j < hospital[0].length; j++) {
                System.out.print(visited[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");

        for (int i = 0; i < hospital.length; i++) {
            for (int j = 0; j < hospital[0].length; j++)
                if (hospital[i][j] == 1 && visited[i][j] == false)
                    return -1;

        }


        return count;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public void explore(int[][] arr, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || arr[x][y] == 0 || arr[x][y] == 1)
            return;
        System.out.println(x + "  " + y + "   " + arr[x][y] + "  " + count);

        if (arr[x][y] == 2 && visited[x][y] == false) {
            visited[x][y] = true;
            for (int i = 0; i < dx.length; i++) {
                int temp1 = x + dx[i];
                int temp2 = y + dy[i];
                if (temp1 < 0 || temp2 < 0 || temp1 >= arr.length || temp2 >= arr[0].length || arr[temp1][temp2] == 0)
                    continue;
                else if (arr[temp1][temp2] == 1) {
                    count++;
                    arr[temp1][temp2] = 2;
                    System.out.println("");
                    explore(arr, visited, temp1, temp2);
                }
            }
        }
        return;

    }

}
