package B;

abstract class Bike {
    abstract void run();
    public static void print(){
        System.out.println("Abstract Class mein define kia hua method");
    }
}

class Honda4 extends Bike {
    void run() {
        System.out.println("running safely");
    }

    public static void main(String args[]) {
        Bike obj = new Honda4();
        obj.run();
    }
}