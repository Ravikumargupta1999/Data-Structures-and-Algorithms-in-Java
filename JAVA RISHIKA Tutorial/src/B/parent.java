package B;

public class parent {
    int a = 10;
    void print(){
        System.out.println("Parent Method");
    }
}
class child extends parent{
    void printSum(int a,int b){
        System.out.println(a+b);
    }
    public static void main(String[] args) {
        child ch = new child();
        System.out.println(ch.a);
        ch.print();
        ch.printSum(10,20);
    }
}