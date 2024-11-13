import java.util.ArrayList;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        System.out.println(al1.size());
        for(int i=0;i<al1.size();i++)
        {
            System.out.print(al1.get(i)+" ");
        }

        ArrayList<Integer> al2 = new ArrayList<>(10);
        System.out.println(al2.size());
        for(int i=0;i<al2.size();i++)
        {
            System.out.print(al2.get(i)+" Hello");
        }
    }
}
