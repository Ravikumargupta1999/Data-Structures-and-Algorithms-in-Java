package Biweekly_Contest_94;

import java.util.*;

public class Reward_Top_K_Students {
    public static void main(String[] args) {
        String[] positive_feedback = {"smart", "brilliant", "studious"};
        String[] negative_feedback = {"not"};

        String[] report = {"this student is not studious", "the student is smart"};

        int[] student_id = {1, 2};
        int k = 2;
        System.out.println(topStudents(positive_feedback,negative_feedback,report,student_id,k));
    }

    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> positive = new HashSet<>();
        for (String feedback : positive_feedback)
            positive.add(feedback);

        HashSet<String> negative = new HashSet<>();
        for (String feedback : negative_feedback)
            negative.add(feedback);

        int[] arr = new int[report.length];
        for (int i = 0; i < report.length; i++) {

            for (String st : report[i].split(" ")) {
                if (positive.contains(st))
                    arr[i] += 3;
                else if (negative.contains(st))
                    arr[i] -= 1;
            }
        }
//        System.out.println(Arrays.toString(arr));

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < report.length; i++) {
            queue.add(new int[]{student_id[i], arr[i]});
        }

        List<Integer> list = new ArrayList<>();
        while (k-- > 0) {
            int[] temp = queue.poll();
            list.add(temp[0]);
        }
        return list;
    }
}
