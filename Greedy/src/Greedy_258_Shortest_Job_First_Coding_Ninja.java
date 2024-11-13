import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_258_Shortest_Job_First_Coding_Ninja {
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

    public static ArrayList<ArrayList<Integer>> shortestJobFirst(int n, ArrayList<Integer> processId, ArrayList<Integer> arrivalTime, ArrayList<Integer> burstTime) {
        // Write your code here.
        Pair[] result = new Pair[n];
        for (int i = 0; i < n; i++) {
            result[i] = new Pair(processId.get(i), arrivalTime.get(i), burstTime.get(i));
        }

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        Arrays.sort(result, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.arrival == o2.arrival) {
                    if (o1.burst == o2.burst) {
                        if (o1.id > o2.id) {
                            return 1;
                        } else {
                            return -1;
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


        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.burst == o2.burst) {
                    if (o1.arrival == o2.arrival) {
                        if (o1.id > o2.id) {
                            return 1;
                        } else {
                            return -1;
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
        while (i < n && currentTime >= result[i].arrival) {
            pq.add(new Pair(result[i].id, result[i].arrival, result[i].burst));
            i++;
        }
        while (i < n || !pq.isEmpty()) {
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

            ArrayList<Integer> list = new ArrayList<>();
            list.add(ID);
            list.add(AT);
            list.add(BT);
            list.add(WT);
            list.add(TAT);
            arrayList.add(list);

            while (i < n && currentTime >= result[i].arrival) {
                pq.add(new Pair(result[i].id, result[i].arrival, result[i].burst));
                i++;
            }
            if (pq.isEmpty() && i < result.length) {
                pq.add(new Pair(result[i].id, result[i].arrival, result[i].burst));
                i++;
                currentTime += (result[i].arrival - currentTime);
            }
        }
        return arrayList;
    }
}
