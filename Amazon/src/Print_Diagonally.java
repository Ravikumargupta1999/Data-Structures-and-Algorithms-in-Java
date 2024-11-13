import java.util.ArrayList;

public class Print_Diagonally {
    static ArrayList<Integer> downwardDigonal(int n, int arr[][])
    {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<2*n-1;i++)
            al.add(new ArrayList<>());
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                al.get(i+j).add(arr[i][j]);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<al.size();i++)
        {
            for(int j=0;j<al.get(i).size();j++)
            {
                result.add(al.get(i).get(j));
            }
        }
        return result;

    }
}
