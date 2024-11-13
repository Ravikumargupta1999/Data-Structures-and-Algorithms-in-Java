public class Disjoint_set {
    // https://practice.geeksforgeeks.org/problems/disjoint-set-union-find/1#
    int find(int A[], int X) {
        if (X == A[X]) {
            return X;
        }
        return A[X] = find(A, A[X]);
    }

    void unionSet(int A[], int X, int Z) {
        A[find(A, X)] = find(A, Z);
    }
}
