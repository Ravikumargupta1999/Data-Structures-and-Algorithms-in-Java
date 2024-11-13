import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
// https://leetcode.com/problems/reconstruct-itinerary/
public class Video_30_Reconstruct_itinerary {
    HashMap<String, PriorityQueue<String>> graph;
    LinkedList<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        ans = new LinkedList<>();
        for(List<String> ticket : tickets)
        {
            PriorityQueue<String> temp = graph.getOrDefault(ticket.get(0),new PriorityQueue<>());
            temp.add(ticket.get(1));
            graph.put(ticket.get(0),temp);
        }
        dfs("JFK");
        return ans;
    }
    public void  dfs(String src)
    {
        PriorityQueue<String> neighbours = graph.get(src);
        while (neighbours != null && neighbours.size() > 0)
        {
            String nbr = neighbours.remove();
            dfs(nbr);
        }
        ans.addFirst(src);
    }
}
