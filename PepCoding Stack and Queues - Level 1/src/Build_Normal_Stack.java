public class Build_Normal_Stack {
    public static class  CustomStack{
        int[] data;
        int tos;
        public CustomStack(int cap)
        {
            data = new int[cap];
            tos = -1;
        }
        int size()
        {
            return tos+1;
        }
        void display()
        {
            if(tos == -1)
                System.out.println("Empty Stack");
            else
            {
                for(int i = tos;i>=0;i--)
                {
                    System.out.print(data[i]+"  ");
                }
                System.out.print("\n");
            }
        }
        void push(int val)
        {
            if(tos == data.length-1)
                System.out.println("Stack OverFlow");
            else
            {
                tos++;
                data[tos] = val;
            }
        }
        int pop()
        {
            if(tos== -1)
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else
            {
                return data[tos--];
            }
        }
        int top()
        {
            if(tos== -1)
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else
            {
                return data[tos];
            }
        }
    }

    public static void main(String[] args) {
        CustomStack st = new CustomStack(5);
        System.out.print(st.pop()+"\n\n");
        System.out.print(st.top()+"\n\n");
        System.out.print(st.size()+"\n\n");

        st.push(45);
        st.push(16);
        st.push(62);
        st.push(32);
        st.push(98);

        System.out.print(st.pop()+"\n\n");
        System.out.print(st.top()+"\n\n");
        System.out.print(st.size()+"\n\n");

        st.push(98);

        System.out.print(st.top()+"\n\n");
        System.out.print(st.size()+"\n\n");

        st.push(28);
    }
}
