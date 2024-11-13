import java.util.ArrayList;

public class Remove_Prime_Numbers {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(34);
        al.add(24);
        al.add(53);
        al.add(19);
        al.add(37);
        al.add(51);
        al.add(72);
        al.add(83);
        al.add(17);
        al.add(19);
        al.add(56);
        al.add(23);
        System.out.println(al);
        for (int i = al.size() - 1; i >= 0; i--) {
            if (isPrime(al.get(i)))
                al.remove(i);
        }
        System.out.println(al);
    }

    static boolean isPrime(int val) {
        for (int i = 2; i < val; i++)
            if (val % i == 0)
                return false;
        return true;
    }
}
