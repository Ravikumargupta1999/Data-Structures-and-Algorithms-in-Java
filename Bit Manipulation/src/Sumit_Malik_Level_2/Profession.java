package Sumit_Malik_Level_2;

public class Profession {


    static String profession(int level, int pos) {
        if (pos == 1)
            return "Architect";
        String par = profession(level - 1, (pos + 1) / 2);
        if (pos % 2 != 0) {
            return par;
        }
        if (par == "Architect")
            return "Teacher";
        else return "Architect";
    }


}
