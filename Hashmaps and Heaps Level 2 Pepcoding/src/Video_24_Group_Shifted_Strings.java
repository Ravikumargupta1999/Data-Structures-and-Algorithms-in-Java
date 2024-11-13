import java.util.*;

public class Video_24_Group_Shifted_Strings {
    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] str) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : str) {
            String temp = getKey(s);
            if (map.containsKey(temp))
                map.get(temp).add(s);
            else {
                ArrayList<String> al = new ArrayList<>();
                al.add(s);
                map.put(temp, al);
            }
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }

    public static String getKey(String str) {
        String temp = "";
        for (int i = 1; i < str.length(); i++) {
            int a = str.charAt(i) - str.charAt(i - 1);
            if (a < 0)
                a += 26;
            temp += a + "#";
        }
        temp += ".";
        return temp;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
        for (ArrayList<String> lst : shiftedGroup) {
            Collections.sort(lst);
        }
        shiftedGroup.sort(new ListComparator());
        display(shiftedGroup);
    }

    static class ListComparator implements Comparator<List<String>> {
        @Override
        public int compare(List<String> l1, List<String> l2) {
            if (l1.size() != l2.size()) {
                return l2.size() - l1.size();
            }

            String l1str = l1.get(0);
            String l2str = l2.get(0);
            return l1str.compareTo(l2str);

        }
    }

    public static void display(ArrayList<ArrayList<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> currList = list.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }
}
