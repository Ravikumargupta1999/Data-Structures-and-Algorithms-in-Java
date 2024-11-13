package Biweekly_Contest_94;

public class Maximum_Enemy_Forts_That_Can_Be_Captured {
    public int captureForts(int[] forts) {
        int max = 0;
        for (int i = 0; i < forts.length; i++) {
            if(forts[i] == 1) {
                max = Math.max(max, moveLeft(i, forts));
                max = Math.max(max, moveRight(i, forts));
            }
        }
        return max;
    }

    public int moveLeft(int index, int[] forts) {
        if (index == 0)
            return 0;
        int count = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (forts[i] == -1)
                return count;
            count++;
        }
        return 0;
    }

    public int moveRight(int index, int[] forts) {
        if (index == forts.length - 1)
            return 0;
        int count = 0;
        for (int i = index + 1; i < forts.length; i++) {
            if (forts[i] == -1)
                return count;
            else if(forts[i] == 1)
                return 0;
            count++;
        }
        return 0;
    }
}
