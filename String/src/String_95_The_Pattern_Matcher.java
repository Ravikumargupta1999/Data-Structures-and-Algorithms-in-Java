public class String_95_The_Pattern_Matcher {
    // https://practice.geeksforgeeks.org/problems/the-pattern-matcher/1
    public void follPattern(String s)
    {
//        int count = 0;
//        for(char ch : s.toCharArray()){
//            if(ch == 'x' )
//                count++;
//            else if(ch == 'y')
//                count--;
//            if(count < 0)
//            {
//                System.out.println(0);
//                return;
//            }
//        }
//        System.out.println(1);
        int count = 0;
        char prev = ' ';
        for(char ch : s.toCharArray()){
            if(ch == 'x' ) {
                if(prev == 'y' && count !=0){
                    System.out.println(0);
                    return;
                }
                count++;
            }
            else if(ch == 'y') {
                count--;
            }
            prev = ch;
            if(count < 0)
            {
                System.out.println(0);
                return;
            }
        }
        if( count == 0){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }

}
