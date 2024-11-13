public class S_Stack_Queue_298_Implement_two_stacks_in_an_array {
    // https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1#
    static class TwoStack {

        int size;
        int top1, top2;
        int arr[] = new int[100];

        TwoStack() {
            size = 100;
            top1 = -1;
            top2 = size;
        }
    }

    static void push1(int x, TwoStack sq) {
        if (sq.top1 + 1 == sq.top2)
            return;
        else {
            sq.top1++;
            sq.arr[sq.top1] = x;
        }
    }

    static void push2(int x, TwoStack sq) {
        if (sq.top1 + 1 == sq.top2)
            return;
        else {
            sq.top2--;
            sq.arr[sq.top2] = x;
        }
    }

    //Function to remove an element from top of the stack1.
    static int pop1(TwoStack sq) {
        if (sq.top1 == -1)
            return -1;
        else {
            return sq.arr[sq.top1--];
        }
    }

    //Function to remove an element from top of the stack2.
    static int pop2(TwoStack sq) {
        if (sq.top2 == 100)
            return -1;
        else {
            return sq.arr[sq.top2++];
        }
    }

    public static void main(String[] args) {
        TwoStack stack = new TwoStack();
        push1(2, stack);
        push1(3, stack);
        push2(4, stack);
        System.out.println(pop1(stack));
        System.out.println(pop2(stack));
        System.out.println(pop2(stack));

    }
}
