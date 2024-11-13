// https://practice.geeksforgeeks.org/problems/find-transition-point-1587115620/1/?company[]=Amazon&company[]=Amazon&page=3&query=company[]Amazonpage3company[]Amazon

public class Transition_Point {
    static int transitionPoint(int arr[], int n) {
        int lb = 0, ub = n - 1;

        while (lb <= ub) {

            int mid = (lb + ub) / 2;
            if (arr[mid] == 0)
                lb = mid +1 ;
            else if (arr[mid] == 1) {

                if (mid == 0|| (mid > 0 &&arr[mid - 1] == 0))
                    return mid;
                ub = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
