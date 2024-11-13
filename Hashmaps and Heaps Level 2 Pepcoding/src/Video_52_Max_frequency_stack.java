import java.util.HashMap;
import java.util.Stack;

public class Video_52_Max_frequency_stack {
}

class FreqStack {
    HashMap<Integer, Stack<Integer>> st;
    HashMap<Integer, Integer> frequencyMap;
    int maxFreq;

    public FreqStack() {
        st = new HashMap<>();
        frequencyMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int cfreq = frequencyMap.getOrDefault(val, 0);
        cfreq++;
        frequencyMap.put(val, cfreq);

        if (!st.containsKey(cfreq))
            st.put(cfreq, new Stack<Integer>());

        st.get(cfreq).push(val);
        maxFreq = Math.max(maxFreq, cfreq);
    }

    public int pop() {
        int ans = st.get(maxFreq).pop();
        int cfreq = frequencyMap.get(ans);
        cfreq--;
        frequencyMap.put(ans, cfreq);
        if (st.get(maxFreq).size() == 0)
            maxFreq--;
        return ans;
    }
}