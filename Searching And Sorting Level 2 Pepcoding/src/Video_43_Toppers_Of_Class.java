import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/toppers-of-class3826/1#
public class Video_43_Toppers_Of_Class {
    class node {
        int marks;
        int index;

        public void setMarks(int a) {
            this.marks = a;
        }

        public void setIndex(int b) {
            this.index = b;
        }
    }

    void kTop(node[] arr, int n) {
        for (int i = 0; i < n; i++)
            if (i != n - 1)
                System.out.print(arr[i].index + " : " + arr[i].marks + " ,  ");
            else
                System.out.print(arr[i].index + " : " + arr[i].marks + " .");
        System.out.println("\n");
        Arrays.sort(arr, (a, b) -> {
            if (a.marks > b.marks)
                return -1;
            else if (a.marks < b.marks)
                return 1;
            else
                return a.index - b.index;
        });
        for (int i = 0; i < n; i++)
            if (i != n - 1)
                System.out.print(arr[i].index + " : " + arr[i].marks + " ,  ");
            else
                System.out.print(arr[i].index + " : " + arr[i].marks + " .");
        System.out.println("\n");
    }

//    public static void main(String[] args) {
//        int a[] = {1, 2, 3, 4};
//        node[] arr = new node[a.length];
//        for (int i = 0; i < a.length; i++) {
//            node temp = new node();
//            temp.setMarks(a[i]);
//            temp.setIndex(i);
//            arr[i] = temp;
//        }
//        kTop(arr, arr.length);
//    }
}
