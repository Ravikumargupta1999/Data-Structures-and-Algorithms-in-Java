import java.util.HashSet;

public class Professor_and_Parties {
    public static String PartyType( long a[], int n)
    {
        HashSet<Long> set = new HashSet<>();
        for(long val : a)
        {
            if(set.contains(val))
                return "BOYS";
            else
                set.add(val);
        }
        return "GIRLS";
    }
}
