public class Reverse_Bits {
    public static int reverseBits(int n) {
        String str = "01100011000110001100011000110001";
        StringBuilder sf = new StringBuilder();
        System.out.println(sf.reverse());
        sf = sf.append(str);
        sf = sf.reverse();
        return Integer.parseInt(sf.toString(),2);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(322222));
    }
}
