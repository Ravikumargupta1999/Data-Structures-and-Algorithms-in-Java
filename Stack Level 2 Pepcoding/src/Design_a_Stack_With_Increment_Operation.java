// https://leetcode.com/problems/design-a-stack-with-increment-operation/
class CustomStack {
    int[] value ;
    int[] increment;
    int index;
    public CustomStack(int maxSize) {
        value = new int[maxSize];
        increment = new int[maxSize];
        index = -1;
    }

    public void push(int x) {
        if(index + 1 == value.length)
            return;
        index++;
        value[index] = x;
        increment[index] = 0;
    }

    public int pop() {
        if(index == -1)
            return -1;
        int x = value[index];
        int inc = increment[index];
        index--;
        if(index >=0)
            increment[index] += inc;
        return x + inc;

    }

    public void increment(int k, int val) {
        int ind = Math.min(k-1,index);
        if(ind >= 0)
            increment[ind] += val;
    }
}