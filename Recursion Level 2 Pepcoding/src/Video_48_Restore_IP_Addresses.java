import java.util.ArrayList;
import java.util.List;
// https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1
// https://leetcode.com/problems/restore-ip-addresses/
public class Video_48_Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        solve(s,0,0,"",list);
        return list;
    }
    public void solve(String str,int i,int part,String asf,List<String> list)
    {
        if(i == str.length() || part == 4)
        {
            if(i == str.length() && part == 4)
                list.add(asf.substring(0,asf.length()-1));
            return;
        }
        solve(str,i+1,part+1,asf+ str.charAt(i)+".",list);
        if(i+2 <= str.length() && isValid(str.substring(i,i+2)))
        {
            solve(str,i+2,part+1,asf+str.substring(i,i+2)+".",list);
        }
        if(i+3 <= str.length() && isValid(str.substring(i,i+3)))
        {
            solve(str,i+3,part+1,asf+str.substring(i,i+3)+".",list);
        }
    }
    public boolean isValid(String str)
    {
        if(str.charAt(0) == '0')
            return false;
        return Integer.parseInt(str) <=255;
    }
}
