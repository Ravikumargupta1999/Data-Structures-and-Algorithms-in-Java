package Biweekly_Contest_88;

import java.util.Arrays;

public class P2 {
    public static void main(String[] args) {
        LUPrefix obj = new LUPrefix(10);
//        ["LUPrefix","longest","upload","longest","upload","upload","upload","longest","upload","longest","upload","upload","upload","longest"]
//[[10],[],[6],[],[10],[7],[4],[],[2],[],[8],[3],[1],[]]
////        ["LUPrefix","upload","longest","upload","longest","upload","longest"]
////[[4],[3],[],[1],[],[2],[]]
//        obj.upload(3);
//        System.out.println(obj.longest());
//        obj.upload(1);
//        System.out.println(obj.longest());
//
//        obj.upload(2);
//        System.out.println(obj.longest());


        obj.longest();
        obj.upload(6);
        obj.longest();
        obj.upload(10);
        obj.upload(7);
        obj.upload(4);
        obj.longest();
        obj.upload(2);
        obj.longest();
        obj.upload(8);
        obj.upload(3);
        obj.upload(1);
        obj.longest();


    }

}

class LUPrefix {

    int[] longest;
    int max;
    int lastTrue;

    public LUPrefix(int n) {

        longest = new int[n + 1];
        max = 0;
        lastTrue = 0;
    }

    public void upload(int video) {

        if (video == longest.length - 1) {
            longest[video] = 1;
        } else {
            longest[video] = 1 + longest[video + 1];
        }
        System.out.println(video+"   "+ Arrays.toString(longest));
        if (video == lastTrue + 1) {
            max = longest[video];
            lastTrue = video;
        }


    }

    public int longest() {
        System.out.println("Longest : " + max);
        return max;
    }
}
