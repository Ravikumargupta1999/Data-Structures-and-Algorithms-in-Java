import java.util.HashSet;

public class Unique_Email_Addresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails){
            String[] arr = email.split("@");
            set.add(arr[arr.length-1]);
        }
        return set.size();
    }
}
