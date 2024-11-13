public class Video_47_Pattern_Jump {
    // https://practice.geeksforgeeks.org/problems/pattern-jumping4855/1
    static String canJump(Long n) {
        return (n & (n - 1)) == 0 ? "True" : "False";
    }
}
