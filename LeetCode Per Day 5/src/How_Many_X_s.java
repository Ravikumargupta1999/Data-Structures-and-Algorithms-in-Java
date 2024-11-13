public class How_Many_X_s {
    int countX(int L, int R, int X) {
        // code here
        int count = 0;
        for (int i = L + 1 ; i < R;i++)
            count += getOccuranceOfX(i,X);
        return count;
    }
    int getOccuranceOfX(int num,int X){
        int count = 0;
        while (num != 0)
        {
            if(num % 10 == X)
                count++;
            num = num /10;
        }
        return count;
    }
}
