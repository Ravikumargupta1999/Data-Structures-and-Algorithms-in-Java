package Biweekly_Contest_79;

import java.util.HashMap;
import java.util.HashSet;

public class Sender_With_Largest_Word_Count {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<senders.length;i++){
            String sender = senders[i];
            int total = messages[i].split(" ").length;
            map.put(sender,map.getOrDefault(sender,0)+1);
        }
        int max = 0;
        String res = "";
        for (int i=0;i<senders.length;i++){
            if(map.get(senders[i]) > max){
                max = map.get(senders[i]);
                res = senders[i];
            }else if(map.get(senders[i]) == max){
                if(res.compareTo(senders[i]) >= 1){
                    res = senders[i];
                }
            }
        }
        return res;
    }
}
