public class Alpa_Beta {
    public static void main(String[] args) {
        int Apha_D =  Math.max(2,Integer.MIN_VALUE);
        System.out.println(Apha_D);
        Apha_D = Math.max(Apha_D,3);
        System.out.println(Apha_D);
        System.out.println("");

        int Apha_E =  Math.max(5,Integer.MIN_VALUE);
        System.out.println(Apha_E);
        Apha_E = Math.max(Apha_E,9);
        System.out.println(Apha_E);
        System.out.println("");

        int beta_B = Math.min(Apha_E,Apha_D);
        System.out.println(beta_B);
    }
}
