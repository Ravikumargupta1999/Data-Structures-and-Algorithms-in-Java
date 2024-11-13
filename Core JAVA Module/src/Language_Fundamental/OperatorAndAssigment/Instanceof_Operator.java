package Language_Fundamental.OperatorAndAssigment;

public class Instanceof_Operator {
    public static void main(String[] args) {
        String str1 = new String("Ravi");
        String str2 = new String("Rishika");
//        System.out.println(str1 instanceof  str2);
        System.out.println(str1 instanceof String);
//        if(str1 instanceof Integer){
//
//        }

        if (str1 instanceof Object) {
            System.out.println("Hiii");
        } else {
            System.out.println("Bye");
        }
        System.out.println("\n\n\n");

//        if( str1 instanceof  StringBuilder)
//        {
//            System.out.println("Hiii");
//        }
//        else
//        {
//            System.out.println("Bye");
//        }
        if (null instanceof StringBuilder) {
            System.out.println("Hiii 3\n\n\n\n");
        } else {
            System.out.println("Bye 3\n\n\n");
        }

        if (null instanceof Object) {
            System.out.println("Hiii 5");
        } else {
            System.out.println("Bye 5");
        }
    }


}
