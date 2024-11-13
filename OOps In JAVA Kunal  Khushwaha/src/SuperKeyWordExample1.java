
public class SuperKeyWordExample1 {
    public static void main(String[] args) {
        BoxWeight5 obj = new BoxWeight5(2,3,4,5);
        System.out.println(obj.l+"  "+obj.h+"   "+obj.w);
    }
}

class BoxWeight5 extends Box5 {
    double weight;

    public BoxWeight5() {
        this.weight = -1;
    }
    public BoxWeight5(BoxWeight5 box)
    {
        super(box);
        this.weight = box.weight;
    }
    public BoxWeight5(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }
}

class Box5 {
    double l;
    double h;
    double w;

    Box5() {
        super();
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box5(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box5(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box5(Box5 other) {
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
    }
}
