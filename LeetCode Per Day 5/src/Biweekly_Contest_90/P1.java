package Biweekly_Contest_90;

import java.util.*;

public class P1 {
    public static void main(String[] args) {
        String[] strings = {"bob", "aaa", "ccc", "ddd"};
        System.out.println(oddString(strings));
    }

    public static String oddString(String[] words) {

        HashSet<String> set = new HashSet<>();

        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        for (String word : words) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 1; i < word.length(); i++) {
                int ch1 = (int) word.charAt(i);
                int ch2 = (int) word.charAt(i - 1);
                temp.add(ch1 - ch2);
            }


            map.put(temp, map.getOrDefault(temp, 0) + 1);
            list1.add(temp);

        }
        System.out.println(map);
        System.out.println(list1);
        for (ArrayList<Integer> list : map.keySet()) {
            if (map.get(list) == 1) {
                for (int i = 0; i < list1.size(); i++) {
                    if (list1.get(i).equals(list))
                        return words[i];
                }
            }
        }
        return "";


    }
    public int destroyTargets(int[] nums, int space) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0;i<nums.length;i++)
    {
        if(map.containsKey(nums[i]%space)){
            map.put(nums[i]%space,map.get(nums[i]%space)+1);
        }else {
            map.put(nums[i]%space,1);
        }
    }

    Arrays.sort(nums);

    int res = Integer.MAX_VALUE, mx = 0;
    for(int i = 0;i<nums.length;i++)
    {
        int x = map.get(nums[i] % space);
        if (x > mx) {
            res = nums[i];
            mx = x;
        }
    }
    return res;
}
//    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
//        List<String> list = new ArrayList<>();
//        for(String s1 : queries){
//            for (String s2 : dictionary){
//                int count = 0;
//                for(int i=0;i<s1.length();i++){
//                    if(s1.charAt(i) != s2.charAt(i))
//                        count++;
//                }
//                System.out.println(s1+"   "+s2+"   "+count);
//                if(count <= 2) {
//                    list.add(s1);
//                    break;
//                }
//            }
//            System.out.println("\n");
//        }
//        return list;
//    }
//
//    public static void main(String[] args) {
//        String[] queries = {"word","note","ants","wood"};
//        String[] dictionary = {"wood","joke","moat"};
//        System.out.println(twoEditWords(queries,dictionary));
//    }
}
