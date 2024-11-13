package InterviewQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Video_9_Encrypt_the_string {

    // https://practice.geeksforgeeks.org/problems/encrypt-the-string-10337/1
    String encryptString1(String s) {
        char[] arr = s.toCharArray();

        char ch = arr[0];
        int count = 1;

        StringBuilder  res = new StringBuilder("");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ch) {
                count++;
            } else {
                res.append(ch);
                res.append(count);
                ch = arr[i];
                count = 1;
            }
        }
        res.append(ch);
        res.append(count);

        StringBuilder sb = new StringBuilder(res);
        sb.reverse();
        return sb.toString();

    }
}
