import java.util.*;

public class G_Graph_366_Word_Ladder_II {
    List<List<String>> ans = new ArrayList<>();    //Stores all possible paths

    void DFS(String beginWord, String endWord, HashMap<String, HashSet<String>> adj, List<String> path) {
        path.add(beginWord);  //Push current word
        System.out.println(path);
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        HashSet<String> set = adj.get(beginWord);
        for (String x : set) {
            DFS(x, endWord, adj, path);
        }
        path.remove(path.size() - 1);
    }

    List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, HashSet<String>> adj = new HashMap<>();
        adj.put(beginWord, new HashSet<>());
        for (String st : wordList)
            adj.put(st, new HashSet<>());
        HashSet<String> dict = new HashSet<>();
        for (String st : wordList) {
            dict.add(st);
        }



        //STEP-1: Find min-depth using BFS

        Queue<String> Q = new LinkedList<>();    //For BFS traversal

        Q.add(beginWord);  //Push start node (beginWord)


        HashMap<String, Integer> visited = new HashMap<>(); //Key->String (Node)...Value->Level (Depth of traversal)
        visited.put(beginWord, 0); //Start node will always be at level 0


       while (!Q.isEmpty()) {
            String curr = Q.poll();
            char[] temp = curr.toCharArray();
            for (int i = 0; i < curr.length(); ++i)    //For all characters
            {
                for (char x = 'a'; x <= 'z'; ++x)    //Try all possible 26 letters
                {
                    if (temp[i] == x)    //Skip if letter is same as in original word
                        continue;

                    temp[i] = x;
                    String st = String.valueOf(temp);
                    if (dict.contains(st))    //Check if new word is present in wordList
                    {

                        if (!visited.containsKey(st))    //check if the new word was already visited
                        {
                            visited.put(st, visited.get(curr) + 1);
                            Q.add(st);
                            adj.get(curr).add(st);
                        } else if (visited.get(st) == visited.get(curr) + 1) //If already visited and new word is the child (We should always move down)
                            adj.get(curr).add(st);
                    }
                    temp = st.toCharArray();
                }
                temp[i] = curr.charAt(i);  //Revert back temp to curr
            }
        }
        System.out.println(adj);
        List<String> path = new ArrayList<>();
        DFS(beginWord, endWord, adj, path); //Find all possible paths with min-depth
        return ans;
    }

}
