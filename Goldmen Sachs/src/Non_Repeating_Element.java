import java.util.HashMap;
//https://practice.geeksforgeeks.org/problems/non-repeating-element3958/1/?company[]=Goldman%20Sachs&company[]=Goldman%20Sachs&page=2&query=company[]Goldman%20Sachspage2company[]Goldman%20Sachs

public class Non_Repeating_Element {

    public int firstNonRepeating(int arr[], int n)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        for(int i=0;i<n;i++)
            if(map.get(arr[i]) == 1)
                return arr[i];
        return 0;
    }
    public static void main(String[] args) {

    }
}
