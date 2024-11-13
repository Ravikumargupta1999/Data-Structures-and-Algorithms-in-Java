package A;

public class Teacher {
    int a ;
    Teacher(int a){
        this.a = a;
    }
    public void print(){
        System.out.println("Hii sweetheart Rishika ");
        System.out.println(a);
    }
    public static void main(String[] args) {
        Teacher obj = new Teacher(10);
        obj.print();


        Teacher obj2 = new Teacher(13);
        obj2.print();
    }
}
