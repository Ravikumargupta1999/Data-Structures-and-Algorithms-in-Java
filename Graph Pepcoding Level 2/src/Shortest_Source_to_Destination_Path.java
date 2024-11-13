import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1/?category[]=Graph&category[]=Graph&difficulty[]=1&page=2&company[]=Amazon&company[]=Microsoft&company[]=Google&company[]=Flipkart&company[]=Adobe&company[]=Samsung&company[]=Snapdeal&company[]=Goldman%20Sachs&company[]=Morgan%20Stanley&company[]=OYO%20Rooms&company[]=D-E-Shaw&query=category[]Graphdifficulty[]1page2company[]Amazoncompany[]Microsoftcompany[]Googlecompany[]Flipkartcompany[]Adobecompany[]Samsungcompany[]Snapdealcompany[]Goldman%20Sachscompany[]Morgan%20Stanleycompany[]OYO%20Roomscompany[]D-E-Shawcategory[]Graph#
public class Shortest_Source_to_Destination_Path {
    class Pair {
        int row;
        int distance;
        int col;

        Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

    }

    int shortestDistance(int n, int m, int arr[][], int x, int y) {
        if (arr[x][y] == 0)
            return -1;
        if (arr[0][0] == 0)
            return -1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.distance - o2.distance;
            }
        });
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        pq.add(new Pair(0, 0, 0));
        while (pq.size() > 0) {
            Pair p = pq.poll();
            if (p.row == x && p.col == y)
                return p.distance;
            for (int i = 0; i < dirs.length; i++) {
                int rowdish = p.row + dirs[i][0];
                int coldDish = p.col + dirs[i][1];
                if (rowdish < 0 || rowdish >= arr.length || coldDish < 0 || coldDish >= arr[0].length || arr[rowdish][coldDish] == 0)
                    continue;
                arr[rowdish][coldDish] = 0;
                pq.add(new Pair(rowdish, coldDish, p.distance + 1));
            }
        }
        return -1;
    }

}

