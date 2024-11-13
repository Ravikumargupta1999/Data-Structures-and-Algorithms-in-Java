import java.util.*;

public class S_Stack_Queue_318_Queue_From_Stack {

    // Regular Method
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    void Push(int x) {
        s1.push(x);
    }

    int Pop() {
        // right hai
//        if(s1.isEmpty())
//            return -1;
//        while (!s1.isEmpty())
//            s2.push(s1.pop());
//
//        int val = s2.pop();
//        while (!s2.isEmpty())
//            s1.push(s2.pop());
//        return val;



        // ye bhi right hai
        // dekho yahan kya ho rha ki new element s1 mein aayega thats good
        // lekin s2 mein jab element store kar lia to ab s2 ke top par jo element pahele aaye the
        // wo store so until s2 is zero s2 will act as a FIFO
        // agar s2 zero kho gya to again s1 se s2 mein sare element le lo
        // then repeat same process
        if(s2.size() > 0 )
            return s2.pop();
        else {
            if(s1.size() == 0)
                return -1;
            while (s1.size() > 0)
            {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
}
