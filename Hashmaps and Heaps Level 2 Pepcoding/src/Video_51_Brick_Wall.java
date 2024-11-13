import java.util.HashMap;
import java.util.List;
//https://leetcode.com/problems/brick-wall/
public class Video_51_Brick_Wall {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(List<Integer> al : wall)
        {
            int sum = 0;
            for(int i=0;i<al.size()-1;i++)
            {
                int val = al.get(i);
                sum += val;
                map.put(val,map.getOrDefault(val,0)+1);
                max = Math.max(max,map.get(sum));
            }
        }
        return wall.size()-max;

    }
}
