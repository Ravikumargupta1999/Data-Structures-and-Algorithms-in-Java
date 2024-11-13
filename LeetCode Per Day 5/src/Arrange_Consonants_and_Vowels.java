public class Arrange_Consonants_and_Vowels {
    class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            next = null;
        }
    }

    public Node arrangeCV(Node head) {
        //write code here and return the head of changed linked list

        Node temp1 = new Node('1');
        Node temp2 = new Node('1');

        Node vowel = temp1;
        Node consonant = temp2;

        while (head != null){
            if(head.data == 'a' || head.data == 'e' || head.data == 'i' || head.data == 'o'|| head.data == 'u'){
                vowel.next = head;
                vowel = vowel.next;
            }else {
                consonant.next = head;
                consonant = consonant.next;
            }
            head = head.next;
        }
        consonant.next = null; // focus You missed it
        vowel.next = temp2.next;
        return temp1.next;
    }
}
