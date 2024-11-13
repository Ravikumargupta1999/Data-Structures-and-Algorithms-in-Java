public class InheritanceExample1 {
    public static void main(String[] args) {
//        Box obj = new Box();
//        Box obj = new Box(5);
        Box obj = new Box(3,4,5);
        System.out.println(obj.l+"  "+ obj.h+"  "+ obj.w);

        Box obj2 = new Box(obj);
        System.out.println(obj2.l+"  "+ obj2.h+"  "+ obj2.w);
    }
}

class Box {
    double l;
    double h;
    double w;

    Box() {
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }
    Box(double l,double h,double w)
    {
        this.l = l;
        this.h = h;
        this.w = w;
    }
    Box(Box other)
    {
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
    }
}
