package Biweekly_Contest_66;

public class Minimum_Number_of_Food_Buckets_to_Feed_the_Hamsters {
    public int minimumBuckets(String hamsters) {
        StringBuilder sb = new StringBuilder(hamsters);
        for (int i = 1; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == 'H' && sb.charAt(i - 1) == 'H' && sb.charAt(i + 1) == 'H')
                return -1;
        }

        if(sb.length() == 1){
            if(sb.charAt(0) == '.')
                return 0;
            else
                return -1;
        }

        if(sb.length() == 2){
            if(sb.charAt(0) == '.' && sb.charAt(1) == '.')
                return 0;
            if(sb.charAt(0) == 'H' && sb.charAt(1) == 'H')
                return -1;
            return 1;
        }
        for (int i = 0; i < sb.length(); i++) {
            if(i == 0){
                if(sb.charAt(i) == 'H')
                    continue;
                else {
                    if(sb.charAt(i+2) != '.' ) {
                        sb.setCharAt(i, 'f');
                    }
                }
            }else if(i == sb.length()-1){
                if(sb.charAt(i) == 'H')
                    continue;
                else {
                    if(sb.charAt(i-2) != 'f' ) {
                        sb.setCharAt(i, 'f');
                    }
                }
            }else {
                if(sb.charAt(i) == '.'){

                }
            }
        }
        return 2;
    }
}
