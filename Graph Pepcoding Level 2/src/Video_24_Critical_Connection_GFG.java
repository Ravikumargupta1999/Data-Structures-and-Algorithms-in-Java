import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/critical-connections/1/?difficulty[]=2&page=3&company[]=Amazon&company[]=Microsoft&company[]=Google&company[]=Flipkart&company[]=Adobe&company[]=Samsung&company[]=Accolite&company[]=MakeMyTrip&company[]=Zoho&company[]=Snapdeal&company[]=Paytm&company[]=Goldman%20Sachs&company[]=Walmart&company[]=Morgan%20Stanley&company[]=FactSet&company[]=OYO%20Rooms&company[]=D-E-Shaw&company[]=Ola%20Cabs&company[]=Oracle&company[]=Directi&company[]=Hike&company[]=VMWare&company[]=Qualcomm&company[]=Facebook&company[]=Cisco&company[]=Linkedin&company[]=Yahoo&company[]=Payu&company[]=Yatra.com&company[]=Media.net%20&company[]=Swiggy&company[]=Twitter&company[]=Apple&company[]=DE%20Shaw&company[]=IBM&company[]=Uber&company[]=Zomato&query=difficulty[]2page3company[]Amazoncompany[]Microsoftcompany[]Googlecompany[]Flipkartcompany[]Adobecompany[]Samsungcompany[]Accolitecompany[]MakeMyTripcompany[]Zohocompany[]Snapdealcompany[]Paytmcompany[]Goldman%20Sachscompany[]Walmartcompany[]Morgan%20Stanleycompany[]FactSetcompany[]OYO%20Roomscompany[]D-E-Shawcompany[]Ola%20Cabscompany[]Oraclecompany[]Directicompany[]Hikecompany[]VMWarecompany[]Qualcommcompany[]Facebookcompany[]Ciscocompany[]Linkedincompany[]Yahoocompany[]Payucompany[]Yatra.comcompany[]Media.net%20company[]Swiggycompany[]Twittercompany[]Applecompany[]DE%20Shawcompany[]IBMcompany[]Ubercompany[]Zomato#
// https://www.youtube.com/watch?v=BsxYwt7A9Wc&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=24
// https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1#
public class Video_24_Critical_Connection_GFG {
    int[] parent;
    int[] disc;
    int[] low;
    int time;
    boolean[] visited;
    boolean[] ap;

    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {

        parent = new int[v];
        disc = new int[v];
        low = new int[v];
        time = 0;
        visited = new boolean[v];
        ap = new boolean[v];
        parent[0] = -1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        criticalConnections(0, adj, ans);
        for (
                int i = 0;
                i < v; i++) {
            if (!visited[i]) {
                criticalConnections(i, adj, ans);
            }
        }
        Collections.sort(ans, (a, b) -> {
            return a.get(0) - b.get(0);
        });
        return ans;
    }

    public void criticalConnections(int u, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> ans) {
        disc[u] = low[u] = time;
        time++;
        int count = 0;
        visited[u] = true;
        ArrayList<Integer> nbrs = adj.get(u);
        for (int i = 0; i < nbrs.size(); i++) {
            int v = nbrs.get(i);
            if (parent[u] == v) {
                continue;
            } else if (visited[v]) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                parent[v] = u;
                count++;
                criticalConnections(v, adj, ans);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    ArrayList<Integer> al = new ArrayList<>();
                    if (u < v) {
                        al.add(u);
                        al.add(v);
                    } else {
                        al.add(v);
                        al.add(u);
                    }
                    ans.add(al);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 8;
        int[][] graph = {{0, 1}, {0, 3}, {0, 4}, {0, 7}, {1, 3}, {1, 5}, {1, 7}, {2, 7}, {3, 4}, {5, 6}, {5, 7}};
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            al.get(graph[i][0]).add(graph[i][1]);
            al.get(graph[i][1]).add(graph[i][0]);
        }
        Video_24_Critical_Connection_GFG g = new Video_24_Critical_Connection_GFG();
        System.out.println(g.criticalConnections(v, al));
    }
}
