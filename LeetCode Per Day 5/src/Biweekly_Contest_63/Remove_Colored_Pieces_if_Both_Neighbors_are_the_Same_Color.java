package Biweekly_Contest_63;

public class Remove_Colored_Pieces_if_Both_Neighbors_are_the_Same_Color {
    public static void main(String[] args) {
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
    }
    public static boolean winnerOfGame(String colors) {

        StringBuilder sb = new StringBuilder(colors);

        boolean flag = true;

        while (true) {
            if(flag){
                if(sb.length() <= 2)
                    return false;
                boolean f = false;
                for(int i=1;i<sb.length()-1;i++){
                    if(sb.charAt(i-1) == 'A' && sb.charAt(i) == 'A' &&sb.charAt(i+1) == 'A') {
                        sb.deleteCharAt(i);
                        f = true;
                        break;
                    }
                }
                if(!f)
                    return false;
            }else {
                if(sb.length() <= 2)
                    return true;
                boolean f = false;
                for(int i=1;i<sb.length()-1;i++){
                    if(sb.charAt(i-1) == 'B' && sb.charAt(i) == 'B' &&sb.charAt(i+1) == 'B') {
                        sb.deleteCharAt(i);
                        f = true;
                        break;
                    }
                }
                if(!f)
                    return true;
            }
            flag = !flag;
        }
    }
    public static boolean winnerOfGame1(String colors) {
        int a = 0;
        int b = 0;
        for (int i=1;i<colors.length()-1;i++){
            if(colors.charAt(i-1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i+1) == 'A' )
                a++;
            if(colors.charAt(i-1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i+1) == 'B' )
                b++;

        }
        return b >= a ? false : true;
    }
}
