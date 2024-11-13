import java.util.HashMap;
import java.util.Map;

public class Is_Square {
    static String isSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        distance(x1,y1,x2,y2,map);
        distance(x1,y1,x3,y3,map);
        distance(x1,y1,x4,y4,map);
        distance(x2,y2,x3,y3,map);
        distance(x2,y2,x4,y4,map);
        distance(x3,y3,x4,y4,map);
        boolean side = false;
        boolean diagonal = false;
        for (int ele : map.keySet())
        {
            if(map.get(ele) == 4)
                side = true;
            if(map.get(ele) == 2)
                diagonal = true;
        }
        return side && diagonal ? "Yes":"No";
    }
    public static void distance(int x1,int y1,int x2,int y2,HashMap<Integer,Integer> map){
        int val = (x1-x2)*(x1-x2) + (y1 -y2)*(y1-y2);
        if(map.containsKey(val))
            map.put(val,map.get(val)+1);
        else
            map.put(val,1);
    }
}
