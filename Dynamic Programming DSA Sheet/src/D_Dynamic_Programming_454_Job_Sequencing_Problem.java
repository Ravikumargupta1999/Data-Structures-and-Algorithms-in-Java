import java.util.*;


public class D_Dynamic_Programming_454_Job_Sequencing_Problem {
    // Leet code
    // //https://leetcode.com/problems/maximum-profit-in-job-scheduling/submissions/
    // https://www.youtube.com/watch?v=CgLpOeRA6Co&t=196s
    public static class Scheduling {
        int start;
        int end;
        int profit;

        public Scheduling(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static int jobScheduling(int[] starTime, int[] endTime, int[] profit) {
        ArrayList<Scheduling> array = new ArrayList<Scheduling>();
        for (int i = 0; i < starTime.length; i++) {
            array.add(new Scheduling(starTime[i], endTime[i], profit[i]));
        }
        Collections.sort(array, new Comparator<Scheduling>() {
                    @Override
                    public int compare(Scheduling o1, Scheduling o2) {
                        Integer i1 = (Integer) o1.end;
                        Integer i2 = (Integer) o2.end;
                        return i1.compareTo(i2);
                    }
                }
        );

        int[] dp = new int[starTime.length];
        dp[0] = array.get(0).profit;
        for (int i = 1; i < starTime.length; i++) {
            int inc = array.get(i).profit;
            int last = -1;
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (array.get(mid).end <= array.get(i).start) {
                    last = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (last != -1) {
                inc += dp[last];
            }
            int exc = dp[i - 1];
            dp[i] = Math.max(inc, exc);

        }
        return dp[starTime.length - 1];
    }

    // GFG
    // https://www.youtube.com/watch?v=LjPx4wQaRIs&t=142s
    // https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> {
            return b.profit - a.profit;
        });

        int maxDeadline = 0;
        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        int count = 0;
        int profit = 0;
        boolean[] visited = new boolean[maxDeadline + 1];

        for (Job job : arr) {
            for (int j = job.deadline; j >= 1; j--) {
                if (!visited[j]) {
                    visited[j] = true;
                    profit += job.profit;
                    count += 1;
                    break;
                }
            }
        }
        int[] res = new int[2];
        res[0] = count;
        res[1] = profit;
        return res;
    }

}
