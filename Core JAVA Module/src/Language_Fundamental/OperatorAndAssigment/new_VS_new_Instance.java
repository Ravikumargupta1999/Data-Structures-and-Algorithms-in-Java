package Language_Fundamental.OperatorAndAssigment;

//public class new_VS_new_Instance {
//    public static void main(String[] args) throws Exception{
//        String[] str = {"Ravi","Arithmatic_Operator"};
//        Object o = Class.forName(str[1]).newInstance();
//        System.out.println("Object created for : "+o.getClass().getName());
//    }
//}
class Simple{
    void message(){System.out.println("Hello Java");}
}

class Test{
    public static void main(String args[]){
        try{
            Class c=Class.forName("Si"); // try simple
            Simple s=(Simple)c.newInstance();
            s.message();

        }catch(Exception e){System.out.println(e);}

    }
}