import java.util.ArrayList;

public class Reverse_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(56);
        al.add(96);
        al.add(26);
        al.add(46);
        al.add(5);
        System.out.println(al);
        int i=0;
        int j = al.size()-1;
        while (i <= j)
        {
            int temp = al.get(i);
            al.set(i,al.get(j));
            al.set(j,temp);
            i++;
            j--;
        }
        System.out.println(al);
    }
}
