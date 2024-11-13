import java.util.Arrays;
import java.util.Comparator;

public class Greedy_239_Job_Scheduling_Problem {
    // https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
    static class Job {
        int id;
        int profit;
        int deadline;

        public Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    // https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
    // https://www.youtube.com/watch?v=LjPx4wQaRIs
    static int[] JobScheduling(Job[] arr, int n) {

        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i].deadline);
        }
        boolean[] visited = new boolean[max + 1];
        int profit = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = arr[i].deadline; j > 0; j--) {
                if (!visited[j]) {
                    count++;
                    visited[j] = true;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        int[] result = new int[2];
        result[0] = count;
        result[1] = profit;
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        Job[] Jobs = new Job[n];

        Jobs[0] = new Job(1, 2, 100);
        Jobs[1] = new Job(2, 1, 19);
        Jobs[2] = new Job(3, 2, 27);
        Jobs[3] = new Job(4, 2, 25);
        Jobs[4] = new Job(5, 1, 15);
        int[] arr = JobScheduling(Jobs, n);
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
// 1,4,20),(2,1,10),(3,1,40),(4,1,30)}
//{(1,2,100),(2,1,19),(3,2,27),
//        (4,1,25),(5,1,15)}