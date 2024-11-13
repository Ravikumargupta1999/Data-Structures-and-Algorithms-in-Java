//https://www.youtube.com/watch?v=lrSXKLmnMV8&t=1742s
//https://www.codingninjas.com/codestudio/problems/n-stacks-in-an-array_1164271?leftPanelTab=1
public class S_Stack_Queue_300_Implement_N_Stack_In_An_Array {
    class NStack {


        int[] top;
        int[] data;
        int[] next;
        int n;
        int s;
        int free;

        public NStack(int N, int S) {
            free = 0;
            n = N;
            s = S;
            top = new int[n];

            data = new int[s];
            next = new int[S];

            for (int i = 0; i < n; i++) {
                top[i] = -1;
            }
            for (int i = 0; i < s; i++) {
                next[i] = i + 1;
            }
            next[s - 1] = -1;
        }

        public boolean push(int item, int sn) {
            // check for overflow
            if (free == -1) {
                return false;
            }


            // find index
            int i = free;

            // update free
            free = next[i];

            // insert element into array
            data[i] = item;

            // update next
            next[i] = top[sn - 1];

            // update top
            top[sn - 1] = i;

            return true;
        }

        public int pop(int sn) {
            if (top[sn - 1] == -1)
                return -1;


            int index = top[sn - 1];

            top[sn - 1] = next[index];

            next[index] = free;

            free = index;

            return data[index];
        }
    }
}