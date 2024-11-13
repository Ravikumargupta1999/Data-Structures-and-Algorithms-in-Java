import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
// https://practice.geeksforgeeks.org/problems/keypad-typing0119/1/?company[]=Amazon&company[]=Amazon&page=3&query=company[]Amazonpage3company[]Amazon#

public class Keypad_Typing {
    public static String printNumber(String s, int n)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',2);map.put('b',2);map.put('c',2);
        map.put('d',3);map.put('e',3);map.put('f',3);
        map.put('g',4);map.put('h',4);map.put('i',4);
        map.put('j',5);map.put('k',5);map.put('l',5);
        map.put('m',6);map.put('n',6);map.put('o',6);
        map.put('p',7);map.put('q',7);map.put('r',7);map.put('s',7);
        map.put('t',8);map.put('u',8);map.put('v',8);
        map.put('w',9);map.put('x',9);map.put('y',9);map.put('z',9);
        String str = "";
        for(int i=0;i<n;i++)
        {
            str = str + map.get(str.charAt(i));
        }
        return str;




    }
    public static void main(String[] args) {

    }
}
