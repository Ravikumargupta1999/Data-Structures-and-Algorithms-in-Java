public class S_Stack_Queue_336_Minimum_Modifications {
    // https://practice.geeksforgeeks.org/contest/microsoft-online-coding-assesment-8/problems/#
    // Wrong
    int count(String S) {
        int countA = 0;
        int countB = 0;
        int count = 0;
        for (char ch : S.toCharArray()) {
            if (ch == 'B') {
                countB++;
                if (countB > countA)
                    count++;
            } else
                countA++;
        }
        return count;
    }
    // ye bhi wrong hai
    int count1(String S) {
        int countA = 0;
        int countB = 0;
        int count = 0;
        for (char ch : S.toCharArray()) {
            if (ch == 'B') {
                countB++;
                if (countB > countA) {
                    countB--;
                    countA++;
                    count++;
                }
            } else
                countA++;
        }
        return count;
    }

    int count2(String S)
    {
        int countA = 0;
        int countB = 0;
        int count = 0;
        for (char ch : S.toCharArray()) {
            if (ch == 'B') {
                countB++;
                if (countB > countA) {
                    countB--;
                    countA++;
                    count++;
                }
            } else{
                countA++;
            }
        }
        return count + (countA-countB)/2;
    }
}
