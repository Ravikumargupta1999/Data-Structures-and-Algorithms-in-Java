import java.util.Scanner;

public class Linked_List_Implementation
{

    static Scanner sc=new Scanner(System.in);
    Node head;
    static class Node
    {

        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    static Linked_List_Implementation list = new Linked_List_Implementation();
    public static Linked_List_Implementation insertAtBeginning(Linked_List_Implementation list, int data)
    {
        Node temp = new Node(data);
        temp.next = null;
        if (list.head == null)
        {
            list.head = temp;
        }
        else
        {
            temp.next= list.head;
            list.head=temp;
        }
        return list;
    }



    public static Linked_List_Implementation insertAtEnd(Linked_List_Implementation list, int data)
    {
        Node temp = new Node(data);
        temp.next = null;
        if (list.head == null)
        {
            list.head = temp;
        }
        else
        {
            Node p = list.head;
            while (p.next != null)
            {
                p = p.next;
            }
            p.next = temp;
        }
        return list;
    }


    public static Linked_List_Implementation insertAtPosition(Linked_List_Implementation list, int data)
    {

        Node temp = new Node(data);
        temp.next = null;

        System.out.print("Enter location at which element you want to insert : ");
        int loc = sc.nextInt();
        if(loc == 1)
            insertAtBeginning(list,data);
        else
        {
            if(loc<1)
            {
                System.out.println("Invalid Input");
            }
            else if(loc>length(list)+1){
                System.out.println("Invalid Input");
            }
            else {
                Node temp2 = list.head;
                for (int i = 0; i < loc - 2; i++) {
                    temp2 = temp2.next;
                }
                temp.next = temp2.next;
                temp2.next = temp;
            }

        }
        return list;
    }



    static  void  delete_first_node(Linked_List_Implementation list)
    {
        int len=length(list);

        if (list.head == null)
        {
            System.out.println("List is Empty");
        }
        else
        {
            list.head = list.head.next;
            System.out.println("Deletion Successful");
        }


    }


    static  void  delete_particular_node(Linked_List_Implementation list)
    {
        int loc;
        System.out.print("Enter node to be delete : ");
        loc = Linked_List_Implementation.sc.nextInt();
        if (loc < 1)
        {
            System.out.println("Linked List is Empty\n\n");
        }
        else if(loc> length(list))
        {
            System.out.println("Entered input is larger than length of Linked List");
        }
        else if(loc==1)
        {
            delete_first_node(list);
        }
        else
        {
            Node temp1 = list.head;
            for(int i=0;i<loc-2;i++)
            {
                temp1 = temp1.next;
            }
            Node temp2 = temp1.next;
            temp1.next = temp2.next;
        }


    }


    static  void  delete_last_node(Linked_List_Implementation list)
    {
        int loc;

        if (length(list) < 1)
        {
            System.out.println("Linked List is Empty\n\n");
        }
        else if(length(list)==1)
        {
            delete_first_node(list);
        }
        else
        {
            Node p = list.head;
            Node q = null;
            while (p.next.next != null)
            {
                p = p.next;

            }
            p.next = null;
        }


    }
    public static int get_First()
    {
        if(list.head == null)
            return -1;
        else
            return list.head.data;
    }





    static int length(Linked_List_Implementation list)
    {
        int count=0;
        Node temp = list.head;
        while (temp !=null)
        {
            count++;
            temp=temp.next;
        }
        return  count;
    }


    public static void printList(Linked_List_Implementation list)
    {
        Node temp= list.head;

        int len=length(list);

        if(len<1)
        {
            System.out.println("Linked List is Empty\n\n");
        }

        else
        {


            System.out.print("Linked List Elements are : ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print("\n\n");
        }
    }
    public static void reverse_linked_list(Linked_List_Implementation list)
    {
        Node current,previous,next;
        current =  list.head;
        previous = null;
        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next ;
        }
        list.head = previous;
    }


    public static void main(String[] args)
    {
       // LinkedlistImplementation list = new LinkedlistImplementation();
        int ch ,data;


        while(true)
        {

            System.out.println("Linked List Operation are : ");
            System.out.println("1. Insertion ");
            System.out.println("2. Deletion ");
            System.out.println("3. Get first Element");
            System.out.println("4. Reverse a linked list");
            System.out.println("5. Displaying Element Of Linked List ");
            System.out.println("6. Exit ");



            System.out.print("Enter your choice : ");
            ch= Linked_List_Implementation.sc.nextInt();
            switch (ch)
            {

                case 1 :
                    System.out.println("1. Insert at Begin ");
                    System.out.println("2. Insert  at particular position");
                    System.out.println("3. Insert at End ");

                    int a;
                    System.out.print("Enter your choice : ");
                    a= Linked_List_Implementation.sc.nextInt();
                    switch (a)
                    {

                        case 1:
                            System.out.print("Enter Element to insert in the Beginning of  Linked List : ");
                            data = Linked_List_Implementation.sc.nextInt();
                            insertAtBeginning(list, data);
                            System.out.print("Element Inserted successfully  in the Beginning of Linked List");
                            System.out.println("\n\n");
                            break;


                        case 2:
                            System.out.print("Enter Element to insert in the  Linked List : ");
                            data = Linked_List_Implementation.sc.nextInt();
                            insertAtPosition(list, data);
                            System.out.println("");
                            System.out.println("");
                            break;


                        case 3:
                            System.out.print("Enter Element to insert in the end of  Linked List : ");
                            data = Linked_List_Implementation.sc.nextInt();
                            insertAtEnd(list, data);
                            System.out.print("Element Inserted successfully in the end of Linked List");
                            System.out.println("\n\n");
                            break;

                        default:
                            System.out.println("Invalid Input For Insertion Operation\n\n");


                    }
                    break;


                case 2 :
                    System.out.println("1. Delete First Node ");
                    System.out.println("2. Delete Particular Node ");
                    System.out.println("3. Delete Last Node ");
                    int b;
                    System.out.print("Enter your choice : ");
                    b= Linked_List_Implementation.sc.nextInt();
                    switch (b)
                    {
                        case 1 :
                            delete_first_node(list);
                            System.out.println("\n\n");
                            break;
                        case 2 :
                            delete_particular_node(list);
                            System.out.println("\n\n");
                            break;

                        case 3 :
                            delete_last_node(list);
                            System.out.println("\n\n");
                            break;

                        default:
                            System.out.println("Invalid Input For Deletion Operation\n\n");


                    }

                    break;
                case 3 :
                    int value = get_First();
                    System.out.println("First value : "+value);
                    System.out.println("");
                    System.out.println("");
                    break;
                case 4 :
                    reverse_linked_list(list);
                    System.out.println("/n/n");
                    break;
                case 5 :
                    printList(list);
                    break;


                case 6 :
                    System.exit(1);

                default:
                    System.out.println("Invalid Input\n\n");

            }


        }

    }
}
