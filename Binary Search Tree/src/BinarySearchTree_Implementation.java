import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree_Implementation {
    static Scanner s = new Scanner(System.in);

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node root;

    public BinarySearchTree_Implementation() {
        root = null;
    }

    public static Node insert(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static int IsEmpty(Node root) {
        if (root == null)
            return 1;
        else
            return 0;
    }

    public static Node Delete(Node root, int data) {
        //
        if (root == null)
            return root;
            //
        else if (data < root.data)
            root.left = Delete(root.left, data);
        else if (data > root.data)
            root.right = Delete(root.right, data);
        else {
            //
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                // Node temp=root;
                root = root.right;
            } else if (root.right == null) {
                //Node temp=root;
                root = root.left;
            } else {
                Node temp = FindMin(root.right);
                root.data = temp.data;
                root.right = Delete(root.right, temp.data);
            }
        }
        return root;
    }

    public static int Search(Node root, int data) {
        if (root == null)
            return 0;
        else if (root.data == data) {
            return 1;
        } else if (data < root.data) {
            return Search(root.left, data);
        } else
            return Search(root.right, data);

    }

    public static void Inorder(Node root) {
        if (root == null)
            return;
        Inorder(root.left);
        System.out.print(root.data + "   ");
        Inorder(root.right);
    }

    public static void Preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + "   ");
        Postorder(root.left);
        Inorder(root.right);
    }

    public static void Postorder(Node root) {
        if (root == null)
            return;
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data + "   ");
    }


    public static Node FindMin(Node root) {
        if (root == null) {
            return root;
        } else if (root.left == null) {
            return root;
        } else
            return FindMin(root.left);

    }

    public static Node FindMax(Node root) {
        if (root == null) {
            // System.out.println("Tree is Empty");
            return root;
        } else if (root.right == null) {
            return root;
        } else
            return FindMax(root.right);

    }

    public static int FindHeight(Node root) {
        if (root == null)
            return -1;
        int leftHeight = FindHeight(root.left);
        int rightHeight = FindHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int NodeHeight(Node root, int data) {
        int height;
        if (root == null)
            return -1;
        else if (root.data == data)
            height = FindHeight(root);
        else if (data <= root.data)
            height = NodeHeight(root.left, data);
        else
            height = NodeHeight(root.right, data);
        return height;
    }

    public static void Leverorder(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node current = q.peek();
            System.out.print(current.data + "   ");
            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
            q.poll();
        }

        //   while ()
    }

    public static Node Find(Node root, int data) {
        if (root == null)
            return null;
        else if (root.data == data)
            return root;
        else if (root.data < data)
            return Find(root.right, data);
        else
            return Find(root.left, data);
    }

    public static Node GetSuccessor(Node root, int data) {
        Node current = Find(root, data);
        if (current == null)
            return null;
        if (current.right != null)
            return FindMin(current.right);
        else {
            Node Successor = null;
            Node Ancestor = root;
            while (Ancestor != current) {
                if (current.data < Ancestor.data) {
                    Successor = Ancestor;
                    Ancestor = Ancestor.left;
                } else
                    Ancestor = Ancestor.right;
            }
            return Successor;
        }
    }

    public static Node GetPredecessor(Node root, int data) {
        Node current = Find(root, data);
        if (current == null)
            return null;
        if (current.left != null) {
            Node temp = current.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            return temp;
        } else {
            Node Successor = null;
            Node Ancestor = root;
            while (current != Ancestor) {
                if (current.data > Ancestor.data) {
                    Successor = Ancestor;
                    Ancestor = Ancestor.right;
                } else
                    Ancestor = Ancestor.left;

            }
            return Successor;
        }

    }

    public static void main(String[] args) {
        BinarySearchTree_Implementation bt = new BinarySearchTree_Implementation();
        while (true) {
            System.out.println("Operation : ");
            System.out.println("         1.  Insertion ");
            System.out.println("         2.  Deletion");
            System.out.println("         3.  Search ");
            System.out.println("         4.  Find Minimum Element");
            System.out.println("         5.  Find Maximum Element ");
            System.out.println("         6.  Pre order Traversal ");
            System.out.println("         7.  In order traversal ");
            System.out.println("         8.  Post Order traversal ");
            System.out.println("         9.  Level Order Traversal ");
            System.out.println("         10. Height of tree ");
            System.out.println("         11. Height of Node");
            System.out.println("         12. In order successor ");
            System.out.println("         13. In order predecessor");
            System.out.println("         14. Exit ");
            System.out.print("Enter Choice :  ");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert :  ");
                    int value = s.nextInt();
                    root = insert(root, value);
                    System.out.println("");
                    break;
                case 2:

                    int emptycheck = IsEmpty(root);
                    if (emptycheck == 1)
                        System.out.println("BST is Empty ");
                    else {
                        System.out.print("Enter value to delete :  ");
                        int valueee = s.nextInt();
                        int valuedelete = Search(root, valueee);
                        //root = Delete(root, valueee);
                        if (valuedelete == 0) {
                            System.out.println("Node  " + valueee + "  is not present is BST");
                        } else {
                            root = Delete(root, valueee);
                            System.out.println("Node " + valueee + "  Deleted ");
                        }


                    }
                    System.out.println("");
                    break;
                case 3:
                    int emptycheck3 = IsEmpty(root);
                    if (emptycheck3 == 1) {
                        System.out.println("BST is Empty ");
                        System.out.println("");
                    } else {
                        System.out.print("Enter the value to search : ");
                        int value1 = s.nextInt();
                        int data = Search(root, value1);
                        // System.out.println(data);
                        if (data == 1) {
                            System.out.println("Element Found");
                            System.out.println();
                        } else {
                            System.out.println("Element not found");
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    int emptycheck4 = IsEmpty(root);
                    if (emptycheck4 == 1)
                        System.out.println("BST is Empty ");
                    else {
                        Node minn = FindMin(root);
                        if (minn == null)
                            System.out.println("BST is Empty ");
                        else
                            System.out.println("Minimum value in BST is :  " + minn.data);
                    }
                    System.out.println("");
                    break;
                case 5:
                    int emptycheck5 = IsEmpty(root);
                    if (emptycheck5 == 1)
                        System.out.println("BST is Empty ");
                    else {
                        Node maxx = FindMax(root);
                        if (maxx == null)
                            System.out.println("BST is Empty ");
                        else
                            System.out.println("Maximum value in BST is :  " + maxx.data);
                    }
                    System.out.println();
                    break;
                case 6:
                    int emptycheck6 = IsEmpty(root);
                    if (emptycheck6 == 1)
                        System.out.println("BST is Empty ");
                    else {
                        System.out.print("Pre order traversal is :  ");
                        Preorder(root);
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 7:
                    int emptycheck7 = IsEmpty(root);
                    if (emptycheck7 == 1)
                        System.out.println("BST is Empty ");
                    else {
                        System.out.print("In order traversal is :  ");
                        Inorder(root);
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 8:
                    int emptycheck8 = IsEmpty(root);
                    if (emptycheck8 == 1)
                        System.out.println("BST is Empty ");
                    else {
                        System.out.print("Post order traversal is :  ");
                        Postorder(root);
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 9:
                    int emptycheck9 = IsEmpty(root);
                    if (emptycheck9 == 1)
                        System.out.println("BST is Empty ");
                    else {
                        System.out.print("Level order traversal is :  ");
                        Leverorder(root);
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 10:
                    System.out.print("Height of tree is :  ");
                    int height = FindHeight(root);
                    System.out.println(height);
                    System.out.println();
                    System.out.println("");
                    break;
                case 11:
                    int emptycheck11 = IsEmpty(root);
                    if (emptycheck11 == 1)
                        System.out.println("BST is Empty ");
                    else {
                        System.out.print("Enter Node :  ");
                        int value3 = s.nextInt();
                        int val = Search(root, value3);
                        if (val == 1) {
                            int nodeheight = NodeHeight(root, value3);
                            //Node minnimum=FindMin(root);
                            System.out.println("Height of Node  " + value3 + "  is  :  " + nodeheight);

                        } else {
                            System.out.println("Node not found");

                        }
                    }
                    System.out.println("");
                    break;

                case 12:
                    int emptycheck12 = IsEmpty(root);
                    if (emptycheck12 == 1)
                        System.out.println("BST is Empty ");
                    else {
                        System.out.print("Enter node :  ");
                        int value4 = s.nextInt();
                        int val6 = Search(root, value4);
                        if (val6 == 1) {
                            // Node temp = GetSuccessor(root, value4);
                            Node temp4 = FindMax(root);
                            if (temp4 == null)
                                System.out.println("BST is empty ");
                            else if (value4 == temp4.data)
                                System.out.println("As " + value4 + "  is maximum value of tree so inorder successor do not exist");
                            else {
                                Node temp = GetSuccessor(root, value4);
                                System.out.println("In order successor of  " + value4 + "  is  :  " + temp.data);
                            }
                        } else {
                            System.out.println("Node not found");
                        }
                    }
                    System.out.println("");
                    break;
                case 13:
                    int emptycheck13 = IsEmpty(root);
                    if (emptycheck13 == 1)
                        System.out.println("BST is Empty ");
                    else {

                        System.out.print("Enter node :  ");
                        int ddata2 = s.nextInt();
                        int val3 = Search(root, ddata2);
                        if (val3 == 1) {
                            Node temp2 = GetPredecessor(root, ddata2);
                            Node temp5 = FindMin(root);
                            if (temp5 == null) {
                                System.out.println("BST is Empty");
                            } else if (ddata2 == temp5.data) {
                                System.out.println("As " + ddata2 + "  is minimum value of tree so inorder predecessor do not exist");
                            } else {
                                System.out.println("In order successor of  " + ddata2 + "  is  :  " + temp2.data);
                            }
                        } else {
                            System.out.println("Node  " + ddata2 + "  not found");
                        }
                    }
                    System.out.println("");
                    break;
                case 14:
                    System.exit(1);
                default:
                    System.out.println("Invalid Input\n");
            }
        }
    }

    public void levelOrder(Node node) {

    }
}
