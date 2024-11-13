package Google_Tagged_Leetcode_Question;

public class Leet_Code_2241_Design_an_ATM_Machine {
    class ATM {
        int[] atm;
        int[] money;

        public ATM() {
            atm = new int[5];
            money = new int[]{20, 50, 100, 200, 500};
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; i++)
                atm[i] += banknotesCount[i];
        }

        public int[] withdraw(int amount) {
            int[] res = new int[5];

            int[] temp = new int[5];
            for (int i = 0; i < 5; i++) {
                temp[i] = atm[i];
            }


            for (int i = 4; i >= 0; i--) {
                int requiredNote = amount / money[i];
                int availableNotes = atm[i];
                if (requiredNote > availableNotes)
                    continue;
                else if (requiredNote == availableNotes) {
                    atm[i] = 0;
                    amount = amount - (money[i] * availableNotes);
                    res[i] = availableNotes;
                } else {
                    amount = amount - (money[i] * requiredNote);
                    atm[i] = atm[i] - requiredNote;
                    res[i] = requiredNote;
                }
            }
            if (amount == 0)
                return res;
            for (int i = 0; i < 5; i++) {
                atm[i] = temp[i];
            }
            return new int[]{-1};
        }
    }


}
