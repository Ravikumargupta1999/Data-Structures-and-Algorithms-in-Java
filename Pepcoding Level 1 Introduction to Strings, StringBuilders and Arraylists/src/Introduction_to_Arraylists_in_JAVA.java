import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;

public class Introduction_to_Arraylists_in_JAVA {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("Initial Size : " + al.size());

        // Add Element
        al.add(67);
        al.add(28);
        al.add(56);
        al.add(97);
        al.add(12);
        System.out.println("Updated ArrayList : "+al);
        System.out.println("Element at index 1 : "+al.get(3));
//        System.out.println("Get  : "+al.get(6));

        // Set
        al.set(1,45);
        System.out.println("\n\nUpdated ArrayList : "+al);

        al.remove(4);
        System.out.println("\n\nModified ArrayList : "+al);


    }
}
