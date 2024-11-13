
public class SuperKeyWordExample2 {
    public static void main(String[] args) {
        BoxWeight6 obj = new BoxWeight6(2,3,4,5);
        System.out.println(obj.l+"  "+obj.h+"   "+obj.w);
    }
}

class BoxWeight6 extends Box7 {
    double weight;

    public BoxWeight6() {
        this.weight = -1;
    }
    public BoxWeight6(BoxWeight5 box)
    {
//        super(box);
        this.weight = box.weight;
//        super(box);
    }
    public BoxWeight6(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }
}

class Box6 {
    double l;
    double h;
    double w;

    Box6() {
        super();
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box6(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box6(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box6(Box7 other) {
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
    }
}
