public interface Rishikaa {
    public void m1();
}
interface aman{
    public int m1(int a);
}

class Ravi implements Rishikaa,aman {
    public int m1(int a) {
        System.out.println("Hello");
        return 1;
    }
    public void m1(){
        System.out.println("Hii");
    }

    public static void main(String[] args) {
        Ravi obj = new Ravi();
        obj.m1();
    }
}
