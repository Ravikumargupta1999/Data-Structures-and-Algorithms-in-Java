package Language_Fundamental.OperatorAndAssigment;

public class instanceof_Vs_isInstance {
    public static void main(String[] args) {
        String str = new String("");
        if(str instanceof String)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }

    }
}
class Test1 {
    public static void main(String[] args)
            throws ClassNotFoundException
    {

        // returns the Class object for this class
        Class myClass = Class.forName("Test1");

        System.out.println("Class represented by myClass: "
                + myClass.toString());

        // get the Class instance using forName() method
        Class c = Class.forName("java.lang.String");

        System.out.println("Class represented by c: "
                + c.toString());

        // Check if object c is compatible
        // using isInstance() method
        System.out.println("Is c compatible: "
                + myClass.isInstance(c));
    }
}
