import java.util.ArrayList;

public class Maximum_Sum_of_an_Hourglass {
    public static void main(String[] args) {
        String str = Integer.toBinaryString((int) 1e9);
        System.out.println(str.length() + "  " + str);
    }

    public int deleteString(String s) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        deleteMin(s, 0, 0, list);
        return list.get(0);
    }

    public void deleteMin(String s, int index, int operation, ArrayList<Integer> list) {
        if (s.length() == 0) {
            list.set(0, Math.max(list.get(0), operation));
            return;
        }

//        for (int i = 0; i < s.length() / 2; i++) {
//            for(int k)
//        }
    }

}
