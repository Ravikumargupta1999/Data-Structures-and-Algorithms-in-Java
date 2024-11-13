import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

//
public class S_Stack_Queue_331_Game_With_String {
    static int minValue1(String s, int k){
        HashMap<Character,Integer> count = new HashMap<>();
        for(char ch : s.toCharArray())
            count.put(ch,count.getOrDefault(ch,0)+1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> count.get(b) - count.get(a));
        maxHeap.addAll(count.keySet());
        while (k-- > 0){
            char ch = maxHeap.remove();
            count.put(ch,count.get(ch)-1);
            if(count.get(ch) > 0)
                maxHeap.add(ch);
        }
        int ans = 0;

        // ye bhi sahi hai

//        while (!maxHeap.isEmpty()){
//            char ch = maxHeap.poll();
//            ans += (count.get(ch))*(count.get(ch));
//        }

        for (char ch : count.keySet()){

            ans += (count.get(ch))*(count.get(ch));
        }

        return ans;
    }

    static int minValue(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer value : map.values())
            que.add(value);
        while (k-- > 0)
            que.add(que.poll() - 1);
        int result = 0;
        while (!que.isEmpty())
            result += que.peek() * que.poll();
        return result;

    }

    public static void main(String[] args) {
        System.out.println(minValue1("egsdhatazqwtlkokhllblvcikppyrbhvkbaretudmsyxcmjkyunlqptagiaymivwlwpprlvddtdggmsghhrxxkzfvadhkbfvxu",88));
    }
}
