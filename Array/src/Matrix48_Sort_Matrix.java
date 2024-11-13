import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Matrix48_Sort_Matrix {
    //https://practice.geeksforgeeks.org/problems/sorted-matrix2333/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-1&page=2&query=company[]Amazondifficulty[]-1page2company[]Amazon

    static int[][] sortedMatrix(int N, int Mat[][]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < Mat.length; i++)
            for (int j = 0; j < Mat[0].length; j++)
                pq.add(Mat[i][j]);
        for (int i = 0; i < Mat.length; i++)
            for (int j = 0; j < Mat[0].length; j++)
                Mat[i][j] = pq.poll();
        return Mat;
    }

}
