import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.guru99.com/shortest-job-first-sjf-scheduling.html
// https://www.youtube.com/watch?v=VCIVXPoiLpU
public class Greedy_258_Shortest_Job_First {
    static class Pair {
        int id;
        int arrival;
        int burst;

        public Pair(int id, int arrival, int burst) {
            this.id = id;
            this.arrival = arrival;
            this.burst = burst;
        }
    }

    public static void ShortestJobScheduling(int[][] arr) {
        Pair[] result = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = new Pair(arr[i][0], arr[i][1], arr[i][2]);
        }
        System.out.println("    ......... Initial State .........");
        System.out.println("Process Id    Arrival Time    Burst Time");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("   " + result[i].id + "            " + result[i].arrival + "               " + result[i].burst);
        }
        System.out.println("");

        Arrays.sort(result, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.arrival == o2.arrival) {
                    if (o1.burst == o2.burst) {
                        if (o1.id > o2.id) {
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        if (o1.burst > o2.burst) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                } else {
                    if (o1.arrival > o2.arrival) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        System.out.println("Process Id        Arrival Time        Burst Time");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("    " + result[i].id + "                 " + result[i].arrival + "                " + result[i].burst);
        }
        System.out.println("");

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.burst == o2.burst) {
                    if (o1.arrival == o2.arrival) {
                        if (o1.id > o2.id) {
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        if (o1.arrival > o2.arrival) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                } else {
                    if (o1.burst > o2.burst) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        int currentTime = result[0].arrival;
        pq.add(new Pair(result[0].id, result[0].arrival, result[0].burst));
        int i = 1;
        while (i < arr.length && currentTime >= result[i].arrival) {
            pq.add(new Pair(result[i].id, result[i].arrival, result[i].burst));
            i++;
        }
        System.out.println(currentTime + "  " + pq.size());
        System.out.println("    ........  Final State .........");
        System.out.println("Process Id    Arrival Time    Burst Time    Completion Time   Turnaround time     Waiting time     Response Time");
        System.out.println(" ( Id )         ( AT )          ( BT )         ( CT )             ( TAT )            ( WT )             (RT)");
        while (i < arr.length || !pq.isEmpty()) {
            if (pq.isEmpty() && i < result.length) {
                pq.add(new Pair(result[i].id, result[i].arrival, result[i].burst));
                i++;
            }
            Pair temp = pq.poll();
            int ID = temp.id;
            int AT = temp.arrival;
            int BT = temp.burst;
            int CT = currentTime + BT;
            int TAT = CT - AT;
            int WT = TAT - BT;
            int RT = WT;
            currentTime = currentTime + BT;
            System.out.println("    " + (ID) + "             " + (AT) + "               " + (BT) + "              " + (CT) + "                   " + (TAT) + "                 " + (WT) + "                " + (RT));
            while (i < arr.length && currentTime >= result[i].arrival) {
                pq.add(new Pair(result[i].id, result[i].arrival, result[i].burst));
                i++;
            }
            if (pq.isEmpty() && i < result.length) {
                pq.add(new Pair(result[i].id, result[i].arrival, result[i].burst));
                i++;
                currentTime = result[i].arrival;
            }
        }

    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 1, 3}, {2, 2, 4}, {3, 1, 2}, {4, 4, 4}};
        int[][] arr = {{1, 2, 6}, {2, 5, 2}, {3, 1, 8}, {4, 0, 3}, {5, 4, 4}};
        ShortestJobScheduling(arr);
    }
}

//    Process Queue	Burst time	Arrival time
//        P1        	6	       2
//        P2        	2          5
//        P3	        8          1
//        P4	        3	       0
//        P5	        4	       4