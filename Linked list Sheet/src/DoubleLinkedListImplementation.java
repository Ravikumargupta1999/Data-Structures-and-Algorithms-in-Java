import java.io.*;
import java.util.Scanner;

public class DoubleLinkedListImplementation
{

    static Scanner sc=new Scanner(System.in);
    Node head;
    static class Node
    {

        int data;
        Node left;
        Node right;
        Node(int d)
        {
            data = d;
            left = null;
            right= null;
        }
    }

    public static DoubleLinkedListImplementation insert_at_begin(DoubleLinkedListImplementation list, int data)
    {
        Node temp = new Node(data);
        temp.left = null;
        temp.right =null;
        if(list.head == null)
        {
            list.head = temp;
        }
        else
        {
            temp.right= list.head;
            list.head.left=temp;
            list.head=temp;
        }
        return list;
    }
    public static DoubleLinkedListImplementation insert_at(DoubleLinkedListImplementation list, int data)
    {
        int loc,len,i=1;
        Node temp = new Node(data);
        temp.right = null;
        temp.left=null;

        System.out.print("Enter location at which element you want to insert : ");
        loc=DoubleLinkedListImplementation.sc.nextInt();

        len=length(list);
        if(loc<1)
        {
            System.out.println("Sorry,Double Double Linked List is empty");

        }
        else if (loc>len+1)
        {

            System.out.println("Sorry,Entered Input is greater than length of Linked list");
            System.out.println("Current list is having " + len + " Elements");

        }
        else if(loc==1)
        {
            insert_at_begin(list, data);

        }

        else
        {
            Node p = list.head;
            while ( i<loc-1)
            {
                p=p.right;
                i++;
            }
           // temp=p.right;
            temp.left=p;
            temp.right=p.right;
            p.right=temp;

        }

        System.out.println("\n\n");
        return list;
    }

    public static DoubleLinkedListImplementation insert_at_end(DoubleLinkedListImplementation list, int data)
    {
        Node temp = new Node(data);
        temp.right = null;
        temp.left = null;
        if (list.head == null)
        {
            list.head = temp;
        }
        else
        {
            Node p = list.head;
            while (p.right != null)
            {
                p = p.right;
            }
            p.right = temp;
            temp.left=p;
        }
        return list;
    }






    static  void  delete_first_node(DoubleLinkedListImplementation list)
    {
        int len=length(list);

        if(len<1)
        {
            System.out.println("Linked List is Empty\n\n");
        }
        else
        {
            Node temp = list.head;
            list.head = temp.right;
            temp.right = null;
            list.head.left = null;

            System.out.println("Deletion Successful");
            System.out.println("\n\n");
        }


    }


    static  void  delete_particular_node(DoubleLinkedListImplementation list)
    {
        int len, loc;
        System.out.print("Enter node to be delete : ");
        loc = DoubleLinkedListImplementation.sc.nextInt();
        len=length(list);
        if (loc < 1)
        {
            System.out.println("Linked List is Empty\n\n");
        }
        else if(loc>len)
        {
            System.out.println("Entered input is larger than length of Linked List \n\n");
        }
        else if(loc==1)
        {
            Node temp = list.head;
            list.head = temp.right;
            temp.right = null;
            System.out.println("Deletion Successful");
            System.out.println("\n\n");
        }
        else if(loc == length(list))
        {
            Node temp = list.head;
            while(temp.right.right != null)
            {
                temp =temp.right;
            }
            temp.right = null;

        }


        else
        {
            int i=1;
            Node temp = list.head;

            while (i<loc)
            {
                temp =temp.right;
                i++;
            }
            temp.left.right=temp.right;
            temp.right.left=temp.left;
            System.out.println("Deletion Successful");
            System.out.println("\n\n");
        }


    }


    static  void  delete_last_node(DoubleLinkedListImplementation list)
    {
        int len;
        len=length(list);
        if (len < 1)
        {
            System.out.println("Linked List is Empty\n\n");
        }
        else if(len==1)
        {
            Node temp = list.head;
            list.head = temp.right;
            temp.right = null;
            System.out.println("Deletion Successful");
            System.out.println("\n\n");
        }
        else
        {
            int i=1;
            Node temp1 = list.head;
            Node temp2 = list.head;

            while (temp1.right !=null)
            {
                temp2=temp1;
                temp1=temp1.right;

            }

            temp2.right=null;
            System.out.println("Deletion Successful");
            System.out.println("\n\n");
        }


    }





    static int length(DoubleLinkedListImplementation list)
    {
        int count=0;
        Node temp = list.head;
        while (temp !=null)
        {
            count++;
            temp=temp.right;
        }
        return  count;
    }


    public static void printList(DoubleLinkedListImplementation list)
    {
        Node temp= list.head;

        int len=length(list);

        if(len<1)
        {
            System.out.println("Double Linked List is Empty\n\n");
        }

        else
        {


            System.out.print("Double Linked List Elements are : ");
            while (temp != null)
            {
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
            System.out.print("\n\n");
        }
    }




    public static void main(String[] args)
    {
        DoubleLinkedListImplementation list = new DoubleLinkedListImplementation();
        int ch ,data;


        while(true)
        {

            System.out.println("Double Linked List Operation are : ");
            System.out.println("1. Insertion ");
            System.out.println("2. Deletion ");
            System.out.println("3. Display ");
            System.out.println("4. Exit ");



            System.out.print("Enter your choice : ");
            ch=DoubleLinkedListImplementation.sc.nextInt();
            switch (ch)
            {

                case 1 :
                    System.out.println("1. Insert at Begin ");
                    System.out.println("2. Insert at Particular Location");
                    System.out.println("3. Insert at End ");

                    int a;
                    System.out.print("Enter your choice : ");
                    a=DoubleLinkedListImplementation.sc.nextInt();
                    switch (a)
                    {

                        case 1:
                            System.out.print("Enter Element to insert in the Beginning of Double Linked List : ");
                            data = DoubleLinkedListImplementation.sc.nextInt();
                            insert_at_begin(list, data);
                            System.out.print("Element Inserted successfully  in the Beginning of DoubleLinked List");
                            System.out.println("\n\n");
                            break;


                        case 2:
                            System.out.print("Enter Element to insert in the  Double Linked List : ");
                            data = DoubleLinkedListImplementation.sc.nextInt();
                            insert_at(list, data);
                            break;


                        case 3:
                            System.out.print("Enter Element to insert in the end of Double Linked List : ");
                            data = DoubleLinkedListImplementation.sc.nextInt();
                            insert_at_end(list, data);
                            System.out.print("Element Inserted successfully in the end of Double Linked List");
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
                    b=DoubleLinkedListImplementation.sc.nextInt();
                    switch (b)
                    {
                        case 1 :
                            delete_first_node(list);
                            break;



                        case 2 :
                            delete_particular_node(list);
                            break;

                        case 3 :
                            delete_last_node(list);
                            break;

                        default:
                            System.out.println("Invalid Input For Deletion Operation\n\n");


                    }

                    break;



                case 3 :
                    printList(list);
                    break;


                case 4 :
                    System.exit(1);

                default:
                    System.out.println("Invalid Input\n\n");

            }


        }

    }
}
