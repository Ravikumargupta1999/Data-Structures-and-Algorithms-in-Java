public class S_Stack_Queue_320_Circular_Queue_Implmentation {

    // https://practice.geeksforgeeks.org/problems/implement-queue-using-array/1

    class MyQueue {
        int front, rear;
        int[] arr = new int[100005];
        int size;

        MyQueue() {
            front = -1;
            rear = -1;
            size = arr.length;
        }

        //Function to push an element x in a queue.
        void push(int value) {
            if (isFull()) {
                return;
            } else {

                if (front == -1 & rear == -1) {
                    front = rear = 0;
                    arr[rear] = value;
                } else if (rear == size - 1 & front != 0) {
                    rear = 0;
                    arr[rear] = value;
                } else {
                    rear = (rear + 1) % size;
                    arr[rear] = value;
                }
                return;
            }
        }

        //Function to pop an element from queue and return that element.
        int pop() {
            int value;
            if (isEmpty()) {
                return -1;
            } else {
                value = arr[front];
                if (front == rear) {
                    front = rear = -1;
                } else {
                    front = (front + 1) % size;
                }
                return value;
            }
        }

        boolean isEmpty() {
            if (front == -1 & rear == -1) {
                return true;
            } else {
                return false;
            }
        }

        boolean isFull() {
            if ((rear + 1) % size == front) {
                return true;
            } else {
                return false;
            }
        }
    }
}