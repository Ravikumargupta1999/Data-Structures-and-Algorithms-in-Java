public class Video_27_Hashcode_Override {
    static class Pair{
        int index;
        String str ;
        public Pair(int index,String str)
        {
            this.index = index;
            this.str = str;
        }
        @Override
        public String toString()
        {
//            return "I am King";
//            return index+"  "+str;
            return "( " +index+" , "+str+" )";
        }
    }
    public static void solution()
    {
        Pair p = new Pair(55,"Ravi");
        System.out.println(p);
        System.out.println(p.index);
        System.out.println(p.str);
        System.out.println("\n\n");

        p = new Pair(56,"Suyog");
        System.out.println(p);
        System.out.println(p.index);
        System.out.println(p.str);
    }
    public static void main(String[] args) {
        solution();
    }
}
