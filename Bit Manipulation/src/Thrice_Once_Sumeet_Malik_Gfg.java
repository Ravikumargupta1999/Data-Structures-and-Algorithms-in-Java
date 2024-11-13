import java.util.HashMap;
import java.util.Map;

public class Thrice_Once_Sumeet_Malik_Gfg {
    static int singleElement1(int[] arr , int n) {
        String[] str = new String[n];
        for(int i=0;i<n;i++)
        {
            str[i] = Integer.toBinaryString(arr[i]);
        }
        for(int i=0;i<n;i++)
        {
            String s = str[i];
            while (s.length() != 32)
            {
                s = "0"+s;
            }
            str[i] = s;
        }
        String result = "";
        for(int i=0;i<32;i++)
        {
            int count =0;
            for(int j=0;j<n;j++)
            {
                if(str[j].charAt(i) == '1')
                    count++;
            }
            if (count % 3 == 1)
            {
                result = result + "1";
            }
            else
            {
                result = result + "0";
            }
        }
        int val = Integer.parseInt(result);
        return getDecimal(val);

    }
    public static int getDecimal(int binary){
        int decimal = 0;
        int n = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int temp = binary%10;
                decimal += temp*Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        return decimal;
    }

    // gfg easy
    static int singleElement(int[] a , int N) {
        Map<Integer, Integer> fmap = new HashMap<>();
        for(int i = 0; i < N;i++)
        {
            if(!fmap.containsKey(a[i])) fmap.put(a[i],0);

            fmap.put(a[i],fmap.get(a[i])+1);
        }
        for(Map.Entry<Integer, Integer> me : fmap.entrySet())
        {
            if(me.getValue()==1)
            {
                return me.getKey();
            }
        }
        return -1;
    }

    // pep coding hard solution
    // not accepting
    public static int solution(int[] arr)
    {
        int tn = Integer.MAX_VALUE ,tnp1 = 0,tnp2 =0;

        for(int i=0;i<arr.length;i++)
        {
            int cwtn = arr[i] & tn;
            int cwtn1 = arr[i] & tnp1;
            int cwtn2 = arr[i] & tnp2;

            tn = tn & (~cwtn);
            tnp1 = tnp1 | cwtn;

            tnp1 = tnp1 & (~cwtn1);
            tnp2 = tnp2 | cwtn1;

            tnp2 = tnp2 & (~cwtn2);
            tn = tn | cwtn2;
        }
        return tnp1;
    }
    public static void main(String[] args) {
        int n = 4;
        int arr[] = {1, 10, 1, 1};
        System.out.println(singleElement(arr,n));
    }
}
