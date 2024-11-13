public class Video_3_Combinations_in_JAVA_Recursive {
    public static void combinations(int currentBox, int totalBoxes, int totalSelected, int totalItem, String answerSoFar) {
        if (currentBox > totalBoxes) {
//            System.out.println(totalBoxes+" "+totalItem);
            if (totalSelected == totalItem) {
                System.out.println(answerSoFar);
            }
            return;
        }
        combinations(currentBox + 1, totalBoxes, totalSelected + 1, totalItem, answerSoFar + "" + 'i' + "");
        combinations(currentBox + 1, totalBoxes, totalSelected, totalItem, answerSoFar + "-");
    }

    public static void main(String[] args) {
        combinations(1, 5, 0, 3, "");
    }
}
