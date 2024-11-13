import java.util.HashMap;
// https://leetcode.com/problems/map-sum-pairs/submissions/
// https://www.youtube.com/watch?v=Z7dkugscqLA&list=PL-Jc9J83PIiHgzR2UIDD7MI2ABIIZztON&index=7
public class A_Trie_7_Map_Sum_Pairs {
    class MapSum {

        class Nodes
        {
            Nodes[] children = new Nodes[26];
            int score = 0;
        }
        Nodes root ;
        HashMap<String,Integer> keyVal;
        public MapSum() {
            root = new Nodes();
            keyVal = new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta = val - keyVal.getOrDefault(key,0);
            keyVal.put(key,val);
            Nodes curr = root;
            for(int i=0;i<key.length();i++)
            {
                char ch = key.charAt(i);
                if(curr.children[ch-'a'] == null)
                {
                    curr.children[ch-'a'] = new Nodes();
                }
                curr = curr.children[ch-'a'];
                curr.score += delta;
            }
        }

        public int sum(String prefix) {
            Nodes curr = root;
            for(int i=0;i<prefix.length();i++)
            {
                char ch = prefix.charAt(i);
                if(curr.children[ch-'a'] == null)
                {
                    return 0;
                }
                curr = curr.children[ch-'a'];
            }
            return curr.score;
        }
    }
}
