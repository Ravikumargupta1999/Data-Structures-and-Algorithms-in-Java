import java.util.Comparator;
import java.util.PriorityQueue;

public class Weekly_Contest_422 {

    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,0,0}};
        System.out.println(minTimeToReach(arr));
    }

    public static int minTimeToReach(int[][] moveTime) {
        PriorityQueue<Container> queue = new PriorityQueue<Container>(new Comparator<Container>() {
            @Override
            public int compare(Container o1, Container o2) {
              return o1.time - o2.time;
            }
        });
        int n = moveTime.length;
        int m = moveTime[0].length;

        queue.add(new Container(0,0,0));

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (queue.size() > 0){
            Container top = queue.poll();
            if(top.row == n-1 && top.col == m-1){
                return  top.time;
            }

            if(top.col + 1 < m && visited[top.row][top.col+1] == false){
                visited[top.row][top.col+1] = true;
                queue.add(new Container(top.row,top.col+1,Math.max(moveTime[top.row][top.col+1],top.time)+1));
            }
            if(top.row+1 < n && visited[top.row+1][top.col] == false){
                visited[top.row+1][top.col] = true;
                queue.add(new Container(top.row+1,top.col,Math.max(moveTime[top.row+1][top.col],top.time)+1));
            }
            if(top.col-1 >=0 && visited[top.row][top.col-1] == false){
                queue.add(new Container(top.row,top.col-1,Math.max(moveTime[top.row][top.col-1],top.time)+1));
                visited[top.row][top.col-1] = true;
            }
            if(top.row-1 >=0 && visited[top.row-1][top.col] == false){
                queue.add(new Container(top.row-1,top.col,Math.max(moveTime[top.row-1][top.col],top.time)+1));
                visited[top.row-1][top.col] = true;
            }
        }
        return -1;

    }

    static class Container{
        int row;
        int col;
        int time;
        public  Container(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
