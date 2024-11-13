import org.omg.Messaging.SYNC_WITH_TRANSPORT;
//https://practice.geeksforgeeks.org/problems/replace-a-word5553/1/?company[]=Adobe&company[]=Adobe&page=6&query=company[]Adobepage6company[]Adobe
// TLE
public class Replace_Word {
    static String replaceAll(String str, String oldW, String newW) {
        for(int i=0;i< str.length();i++)
        {
            for(int j= i;j<str.length();j++)
            {
               // System.out.print(str.substring(i,j+1)+"  ");
               // System.out.println(oldW);
                if(str.substring(i,j+1).compareTo(oldW) == 0)
                {
                    str = str.substring(0,i) + newW + str.substring(j+1);
                    System.out.println(newW);
                }
               // System.out.println("");
            }
        //    System.out.println("");

        }
        //System.out.println(str);
        return str;

    }

    public static void main(String[] args) {

        String S = "t t fxt ucvt t ept tlzt t qvt bgmt t dft nmtt t zst ctct t kct tmht t rct jbjt t wyt d";
        String oldW = "t";
        String newW = "qqs";
        System.out.println(replaceAll(S,oldW,newW));

    }
}
