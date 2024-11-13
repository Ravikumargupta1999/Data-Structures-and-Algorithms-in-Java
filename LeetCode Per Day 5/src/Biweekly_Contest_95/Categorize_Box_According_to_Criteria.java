package Biweekly_Contest_95;

public class Categorize_Box_According_to_Criteria {

//    The box is "Bulky" if:
//    Any of the dimensions of the box is greater or equal to 104.
//    Or, the volume of the box is greater or equal to 109.
//    If the mass of the box is greater or equal to 100, it is "Heavy".
//    If the box is both "Bulky" and "Heavy", then its category is "Both".
//    If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
//    If the box is "Bulky" but not "Heavy", then its category is "Bulky".
//    If the box is "Heavy" but not "Bulky", then its category is "Heavy".

    public static String categorizeBox(int length, int width, int height, int mass) {
        double volume = ((double) length * (double) width * (double) height);
        if ((length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000) && mass >= 100) {
            return "Both";
        } else if (length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000)
            return "Bulky";
        else if (mass >= 100)
            return "Heavy";
        else
            return "Neither";
    }

    public static void main(String[] args) {
        int l = 2909;
        int w =3968;
        int h =3272;
        int mass = 727;
        System.out.println(categorizeBox(l,w,h,mass));
    }
}
