public class S_Stack_Queue_319_N_Queue_Using_Array {
    // https://www.youtube.com/watch?v=_gJ3to4RyeQ&t=2415s
    // https://www.codingninjas.com/codestudio/problems/n-queue-using-array_1170053?leftPanelTab=1
    class NQueue {
        int n;
        int k;
        int[] front;
        int[] rear;
        int[] arr;
        int freeSpot;
        int[] next;

        public NQueue(int N, int S) {
            this.n = S;
            this.k = N;
            front = new int[k];
            rear = new int[k];
            arr = new int[n];
            next = new int[n];
            freeSpot = 0;
            for (int i = 0; i < k; i++)
                front[i] = rear[i] = -1;

            for (int i = 0; i < n; i++)
                next[i] = i + 1;
            next[n - 1] = -1;
        }

        // Enqueues 'X' into the Mth queue. Returns true if it gets pushed into the queue, and false otherwise.
        public boolean enqueue(int x, int m) {
            // overflow
            if (freeSpot == -1) {
                return false;
            }

            // find first freeSpot
            int index = freeSpot;

            // update freeSpot
            freeSpot = next[index];

            // check whether first element
            if (front[m - 1] == -1)
                front[m - 1] = index;
            else
                next[rear[m - 1]] = index;

            // update index
            next[index] = -1;

            // update rear
            rear[m - 1] = index;

            // push element
            arr[index] = x;
            return true;
        }

        // Dequeues top element from Mth queue. Returns -1 if the queue is empty, otherwise returns the popped element.
        public int dequeue(int m) {
            // underflow

            if (front[m - 1] == -1)
                return -1;

            // find index to pop
            int index = front[m - 1];

            // front ko aage badhaoge
            front[m - 1] = next[index];

            // freespot ko aage badhao
            next[index] = freeSpot;
            freeSpot = index;

            return arr[index];
        }
    }

}
