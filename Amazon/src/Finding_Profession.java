import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/finding-profession3834/1/?company[]=Oracle&company[]=Oracle&page=3&query=company[]Oraclepage3company[]Oracle#

public class Finding_Profession {
    static char profession1(int level, int pos) {
        Queue<Character> queue = new LinkedList<>();
        queue.add('e');
        int temp = 0;
        while (temp < level - 1) {

            int size = queue.size();
//            System.out.println(queue + "  " + size);
            while (size-- > 0) {
//                System.out.println("Hello");
                char ch = queue.peek();
                queue.poll();
                if (ch == 'e') {
                    queue.add('e');
                    queue.add('d');
                } else if (ch == 'd') {
                    queue.add('d');
                    queue.add('e');
                }
            }
            temp++;
        }
        System.out.println(queue);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if (i == pos - 1)
                return queue.poll();
            else
                queue.poll();

        }
        return '1';
    }

    static char profession(int level, int pos)

    {
        if (level == 1)
            return 'e';
        if (profession(level - 1, (pos + 1) / 2) == 'd')
            return (pos % 2 > 0) ? 'd' : 'e';
        return (pos % 2 > 0) ? 'e' : 'd';
    }

    public static void main(String[] args) {
        System.out.println(profession(4, 9));
    }
}
