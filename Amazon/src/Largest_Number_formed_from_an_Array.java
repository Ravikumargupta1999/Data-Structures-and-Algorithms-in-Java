import java.util.*;
// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&query=category[]Arrayscompany[]Amazondifficulty[]1page2company[]Amazoncategory[]Arrays

public class Largest_Number_formed_from_an_Array {
    static String printLargest(String[] str) {
        ArrayList<String> arr = new ArrayList<>();
        for(String st : str)
            arr.add(st);
        System.out.println(arr);
        Collections.sort(arr, new Comparator<String>()
        {
            @Override public int compare(String X, String Y)
            {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        System.out.println(arr);
        Iterator it = arr.iterator();
        String result = "";
        while (it.hasNext())
            result = result +it.next();
        return result;

    }

    public static void main(String[] args) {
        String[] str = {"3","30","34","9"};
        System.out.println(printLargest(str));
    }
}
