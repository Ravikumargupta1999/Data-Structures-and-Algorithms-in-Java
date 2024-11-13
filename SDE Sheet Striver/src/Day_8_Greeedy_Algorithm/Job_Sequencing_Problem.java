package Day_8_Greeedy_Algorithm;

import java.util.Arrays;

public class Job_Sequencing_Problem {
    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    // https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
    static int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> {
            return b.profit - a.profit;
        });
        int deadline = 0;
        for (Job job : arr) {
            deadline = Math.max(deadline, job.deadline);
        }
        int count = 0;
        int profit = 0;

        boolean[] flag = new boolean[deadline + 1];
        for (Job job : arr) {
            for (int i = job.deadline; i >= 1; i--) {
                if (!flag[i]) {
                    flag[i] = true;
                    profit += job.profit;
                    count++;
                    break;
                }
            }
        }
        return new int[]{count,profit};
    }

    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2,1,10);
        arr[2] = new Job(3,1,40);
        arr[3] = new Job(4,1,30);
        System.out.println(Arrays.toString(JobScheduling(arr,arr.length)));
    }
}
