import java.util.HashMap;

// https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
// https://www.youtube.com/watch?v=4mi2rO4D_Xk&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=2
public class Video_2_Find_Itinerary_from_Ticket {
    public static void printResult(HashMap<String,String> map)
    {
        HashMap<String,Boolean> res = new HashMap<>();
        int size = map.size();
        for(String key : map.keySet())
        {
            String val = map.get(key);
            res.put(key,true);
            res.put(val,false);
        }
        String source = "";
        for(String key : res.keySet())
        {
            if(res.get(key))
            {
                source = key;
                break;
            }
        }
        while (size-- > 0)
        {
            if(size != 0)
                System.out.print(source+" --> "+map.get(source)+"  ");
            else
                System.out.print(source+" --> "+map.get(source)+" .");
            source = map.get(source);
        }
        System.out.print("\n\n");
    }
    public static void main(String[] args)
    {
        HashMap<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        printResult(dataSet);
    }

}
