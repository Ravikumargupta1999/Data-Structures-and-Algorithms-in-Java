public class InheritanceExample3 {
    public static void main(String[] args) {
        BoxWeight3 b = new BoxWeight3(2, 3, 4, 5);
//        System.out.println(b.l + "   " + b.h + "   " + b.w + "    " + b.weight);
    }
}
class BoxWeight3 extends Box4 {
    double weight;

    public BoxWeight3() {
        this.weight = -1;
    }

    public BoxWeight3(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }
}

class Box3 {
    private double l;
    double h;
    double w;

    Box3() {
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box3(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box3(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box3(Box3 other) {
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
    }
}
