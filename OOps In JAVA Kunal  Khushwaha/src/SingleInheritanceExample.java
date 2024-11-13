public class SingleInheritanceExample {
    public static void main(String[] args) {
        BoxPrice obj = new BoxPrice(5,8,200);
        System.out.println(obj.l+"  "+obj.h+"   "+obj.w);
    }
}
class BoxPrice extends BoxWeight7{
    double cost;
    BoxPrice()
    {
        super();
        this.cost = -1;
    }
    BoxPrice(BoxPrice other)
    {
        super(other);
        this.cost = other.cost;
    }
    BoxPrice(double l, double h, double w, double weight, double cost)
    {
        super(l,h,w,weight);
        this.cost = cost;
    }
    BoxPrice(double side, double weight, double cost)
    {
        super(side,weight);
        this.cost = cost;
    }
}
class BoxWeight7 extends Box7 {
    double weight;

    public BoxWeight7() {
        this.weight = -1;
    }
    public BoxWeight7(BoxWeight7 box)
    {
        super(box);
        this.weight = box.weight;

    }
    public BoxWeight7(double l, double h) {
    }
    public BoxWeight7(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }
}

class Box7 {
    double l;
    double h;
    double w;

    Box7() {
        super();
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box7(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box7(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box7(Box7 other) {
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
    }
}