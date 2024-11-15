package InterviewQuestion;

public class Video_42_Overlapping_Rectangle {
    // https://practice.geeksforgeeks.org/problems/overlapping-rectangles1924/1
    int doOverlap(int l1[], int r1[], int l2[], int r2[]) {
        if (l1[0] == r1[0] || l1[1] == r1[1] || l2[0] == r2[0] || l2[1] == r2[1])
            return 0;
        if (l1[0] >= r2[0] || l2[0] >= r1[0])
            return 0;
        if (r2[1] >= l1[1] || l2[1] < r1[1])
            return 0;
        return 1;
    }
}
