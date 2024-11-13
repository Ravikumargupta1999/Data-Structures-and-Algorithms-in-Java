import java.util.*;

public class S_Stack_Queue_297_Queue_Implementation {
    static Scanner sc = new Scanner(System.in);
    static int[] queue;
    static int FRONT = -1, REAR = -1, size;

    static {
        create();
    }

    public static void main(String[] args) {
        int ch, item;

        while (true) {
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an Element");
            System.out.println("3. Peek");
            System.out.println("4. Display the queue");
            System.out.println("5. Exit");

            System.out.print("Enter your  choice :  ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    enqueue();
                    break;
                case 2:
                    item = dequeue();
                    if (item == 0) {
                        System.out.println("Sorry  , Nothing to Delete Queue is Empty !! ");
                    } else {
                        System.out.println("Deleted item :" + item);
                    }
                    break;
                case 3:
                    item = peek();
                    if (item == 0) {
                        System.out.println("Empty Queue");
                    } else {
                        System.out.println("Peek Element : " + item);

                    }
                    break;
                case 4:
                    traverse();
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    static void create() {
        System.out.print("Enter Size Of Queue : ");
        size = sc.nextInt();
        queue = new int[size];
        System.out.println("Queue created Successfully with size :" + size);
    }

    static void enqueue() {
        int value;
        if (isFull()) {
            System.out.println("Queue is Overflown....\n");
        } else {

            System.out.print("Enter Element : ");
            value = sc.nextInt();
            if (FRONT == -1 && REAR == -1) {
                REAR = FRONT = 0;
            } else {
                REAR++;
            }
            queue[REAR] = value;
            System.out.println("Insertion Successful and Inserted Element is :" + value);
        }
    }

    static boolean isFull() {
        if (REAR == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    static int dequeue() {
        int value;
        if (isEmpty()) {
            return 0;
        } else {
            value = queue[FRONT];
            FRONT++;
            if (FRONT > REAR) {
                FRONT = REAR = -1;
            }
            return value;
        }
    }

    static boolean isEmpty() {
        if (FRONT == -1 || FRONT > REAR) {
            return true;
        } else {
            return false;
        }
    }

    static int peek() {
        if (isEmpty()) {
            return 0;
        } else {
            return queue[FRONT];
        }
    }

    static void traverse() {
        if (isEmpty()) {
            System.out.println("Sorry, Nothing to display");
        } else {
            System.out.print("Elements of Queue are : ");
            for (int i = FRONT; i <= REAR; i++) {
                System.out.print(queue[i]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }
}