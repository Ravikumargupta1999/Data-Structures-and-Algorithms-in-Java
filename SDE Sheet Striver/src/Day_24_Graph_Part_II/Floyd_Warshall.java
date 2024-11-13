package Day_24_Graph_Part_II;

public class Floyd_Warshall {
    public void shortest_distance(int[][] dist)
    {

        int V = dist.length;
        int i, j, k;
        for (i = 0; i < V; i++)
        {
            for (j = 0; j < V; j++)
            {

                if (dist[i][j] == -1)
                    dist[i][j] = Integer.MAX_VALUE/5;
            }
        }

        for (k = 0; k < V; k++)
        {
            for (i = 0; i < V; i++)
            {
                for (j = 0; j < V; j++)
                {

                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        for (i = 0; i < V; i++)
        {
            for (j = 0; j < V; j++)
            {
                if (dist[i][j] == Integer.MAX_VALUE/5)
                    dist[i][j] = -1;
            }
        }
    }
}
