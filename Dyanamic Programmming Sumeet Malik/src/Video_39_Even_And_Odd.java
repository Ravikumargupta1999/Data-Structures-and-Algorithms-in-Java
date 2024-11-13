import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/even-and-odd-elements-at-even-and-odd-positions1342/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&page=7&query=category[]Arrayscompany[]Amazonpage7company[]Amazoncategory[]Arrays#

public class Video_39_Even_And_Odd {
    ArrayList<Long> arrangeOddAndEven(long arr[], int n)
    {
        ArrayList<Long> even = new ArrayList<>();
        ArrayList<Long> odd = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (arr[i] % 2 == 0)
                even.add(arr[i]);
            else
                odd.add(arr[i]);
        ArrayList<Long> result = new ArrayList<>();

        for (int i = 0; i < Math.max(even.size(), odd.size()); i++) {
            if( i  < even.size())
                result.add(even.get(i));
            if(i < odd.size())
                result.add(odd.get(i));
        }
        return result;
    }

}
