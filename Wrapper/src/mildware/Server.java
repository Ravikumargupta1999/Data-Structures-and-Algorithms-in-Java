package mildware;

//public class Server {
//}
public class Server implements InterfaceCalculator{
    public int add(int a,int b){
        return a*b;
    }
    public int sub(int a,int b){
        return a/b;
    }
}