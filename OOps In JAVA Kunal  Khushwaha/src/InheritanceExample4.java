public class InheritanceExample4 {
    public static void main(String[] args) {
        Box4 obj = new BoxWeight4(2,3,4,5);
        System.out.println(obj.l+"  "+obj.h+"   "+obj.w);
//        System.out.println(obj.weight);
    }
}

class BoxWeight4 extends Box4 {
    double weight;

    public BoxWeight4() {
        this.weight = -1;
    }

    public BoxWeight4(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }
}

class Box4 {
    double l;
    double h;
    double w;

    Box4() {
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box4(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box4(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box4(Box4 other) {
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
    }
}
