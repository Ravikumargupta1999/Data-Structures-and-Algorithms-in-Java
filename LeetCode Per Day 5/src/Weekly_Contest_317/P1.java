package Weekly_Contest_317;

import java.util.*;

public class P1 {

    public int averageValue(int[] nums) {
        int count = 0;
        int total = 0;
        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                total += num;
                count++;
            }
        }
        if (count != 0)
            return total / count;
        return total;
    }

    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            map.put(creators[i], map.getOrDefault(creators[i], 0) + views[i]);
        }
        int max = 0;
        for (String key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        pair[] arr = new pair[views.length];
        for (int i=0;i<views.length;i++){
            arr[i] = new pair(creators[i],ids[i],map.get(creators[i]),views[i]);
        }

        for (pair p : arr){
            System.out.println(p.key+ "   "+p.ids+"   "+p.views+ "   "+p.to);
        }
        System.out.println("\n");
        Arrays.sort(arr,(a,b)->{
            if(a.views != b.views)
                return b.views - a.views;
            if(a.to != b.to)
                return b.to-a.to;
            return a.ids.compareTo(b.ids);
        });
        for (pair p : arr){
            System.out.println(p.key+ "   "+p.ids+"   "+p.views+"   "+p.to);
        }
        System.out.println("\n");


        List<List<String>> list = new ArrayList<>();
        for (pair temp : arr) {
            List<String> list1 = new ArrayList<>();
            if(temp.views != max)
                return list;

            if(list.size() == 0 || !list.get(list.size()-1).get(0).equals(temp.key) ) {
                list1.add(temp.key);
                list1.add(temp.ids);
                list.add(list1);
                continue;
            }

        }
        return list;
    }
    public static class pair{
        String key;
        String ids;
        int views;
        int to;

        public pair(String key,String ids,int views,int to){
            this.key = key;
            this.ids = ids;
            this.views = views;
            this.to = to;
        }
    }

    public static void main(String[] args) {
//        ["alice","alice","alice"]
//["a","b","c"]
//[1,2,2]
        String[] creators = {"alice","bob","alice","chris"};
        String[] ids = {"one","two","three","four"};
        int[] views = {5,10,5,4};
        System.out.println(mostPopularCreator(creators, ids, views));
    }
    public long makeIntegerBeautiful(long n, int target) {
        int min = 0;
        while (n <=  (long) (Math.pow(10,12))){
            if(sum(n) <= target)
                return min;
            min++;
        }
        return -1;
    }
    public int sum(long num){
        int s = 0;
        while (num != 0){
            s += (num % 10);
            num = num/10;
        }
        return s;
    }
}
