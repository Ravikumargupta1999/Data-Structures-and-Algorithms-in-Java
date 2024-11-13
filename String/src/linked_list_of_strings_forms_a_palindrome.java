
//https://practice.geeksforgeeks.org/problems/linked-list-of-strings-forms-a-palindrome/1/?category[]=palindrome&category[]=palindrome&page=1&query=category[]palindromepage1category[]palindrome#

public class linked_list_of_strings_forms_a_palindrome {
    static class Node
    {
        String data;
        Node next;
        Node(String key)
        {
            data = key;
            next = null;
        }
    }
    public static boolean compute(Node node)
    {
        Node temp = node;
        if(node == null)
            return true;
        String str = "";
        while (temp.next != null) {
            str = str + temp.data;
            temp = temp.next;
        }
        str = str + temp.data;
        int i = 0;
        int j = str.length()-1;
        while (i<= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }


}
