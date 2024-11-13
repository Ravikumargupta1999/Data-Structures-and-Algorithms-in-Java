public class StringBuilder_Operation {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Ravi");
        System.out.println(sb+"\n");

        System.out.println("Get : "+sb.charAt(2)+"\n\n");

        sb.setCharAt(2,'t');
        System.out.println("Update : "+sb+"\n\n");

        sb.deleteCharAt(2);
        System.out.println("Delete : "+sb+"\n\n");

        sb.insert(3,'5');
        System.out.println("Insert : "+sb+"\n\n");

        sb.append('n');
        System.out.println("Append : "+sb+"\n\n");


        System.out.println("Length : "+sb.length()+"\n\n");


    }
}
