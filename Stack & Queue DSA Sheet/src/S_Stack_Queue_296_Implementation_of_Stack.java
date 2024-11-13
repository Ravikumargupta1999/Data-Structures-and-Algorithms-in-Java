import java.util.Scanner;

public class S_Stack_Queue_296_Implementation_of_Stack {
    static Scanner sc = new Scanner(System.in);
    static int stack[], top = -1, size;
    static {
        create();
    }

    public static void main(String[] args) {
        int ch, item;
        while (true) {
            System.out.println("1. Push()");
            System.out.println("2. Pop()");
            System.out.println("3. Peek()");
            System.out.println("4. Traverse()");
            System.out.println("5. Quit");

            System.out.print("Enter your  choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Element : ");
                    item = sc.nextInt();
                    push(item);
                    System.out.println("");
                    break;

                case 2:
                    item = pop();
                    if (item == 0) {
                        System.out.println("Underflow");
                        System.out.println("");
                    } else {
                        System.out.println("Popped item : " + item);
                        System.out.println("");
                    }
                    break;
                case 3:
                    item = peek();
                    if (item == 0) {
                        System.out.println("Underflow");
                    } else {
                        System.out.println("Peek Element : " + item);
                    }
                    System.out.println("");
                    break;
                case 4:
                    traverse();
                    System.out.println("");
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid Input");
                    System.out.println("");
            }
        }
    }

    static void create() {
        System.out.print("Enter Size Of Stack : ");
        size = sc.nextInt();
        stack = new int[size];
        System.out.println("Stack created successfully with size : " + size);
    }

    static void push(int item) {
        if (isFull()) {
            System.out.println("Stack is Overflow\n");
        } else {
            stack[++top] = item;
        }
    }

    static boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    static int pop() {
        if (isEmpty()) {
            return 0;
        } else {
            return stack[top--];
        }
    }

    static boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    static int peek() {
        if (isEmpty()) {
            return 0;
        } else {
            return stack[top];
        }
    }

    static void traverse() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
        } else {
            System.out.print("Elements of stack are : ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
}
