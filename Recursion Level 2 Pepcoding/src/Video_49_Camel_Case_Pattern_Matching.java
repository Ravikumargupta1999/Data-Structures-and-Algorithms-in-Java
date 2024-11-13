import java.util.*;

public class Video_49_Camel_Case_Pattern_Matching {
    // https://www.geeksforgeeks.org/print-words-matching-pattern-camelcase-notation-dictonary/
    ArrayList<String> CamelCase(int n, String[] dictionary, String pattern) {

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < dictionary.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < dictionary[i].length(); j++) {
                if (dictionary[i].charAt(j) >= 'A' && dictionary[i].charAt(j) <= 'Z') {
                    str.append(dictionary[i].charAt(j));
//                    System.out.println(dictionary[i]+"  "+str);
                    ArrayList<String> al;
                    if (map.containsKey(str.toString())) {
                        al = map.get(str.toString());
                        al.add(dictionary[i]);
                        map.put(str.toString(), al);
                    } else {
                        al = new ArrayList<>();
                        al.add(dictionary[i]);
                        map.put(str.toString(), al);
                    }
//                    System.out.println(map);
                }
            }
        }

        boolean wordFound = false;
        for (Map.Entry<String, ArrayList<String>> it : map.entrySet()) {
            if (it.getKey().equals(pattern)) {
                wordFound = true;

            }
        }

        if (!wordFound) {
            return new ArrayList<String>();
        }
        if (map.containsKey(pattern)) {
            ArrayList<String> al = new ArrayList<>();
            al = map.get(pattern);
            Collections.sort(al, (a, b) -> {
                if (a.length() != b.length())
                    return a.length() - b.length();
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i))
                        return a.charAt(i) - b.charAt(i);
                }
                return 1;
            });
            return al;
        }
        return new ArrayList<>();

    }

    public static void main(String[] args) {
        int n = 8;
        String[] Dictionary = {"Hi", "Hello", "HelloWorld",
                "HiTech", "HiGeek", "HiTechWorld",
                "HiTechCity", "HiTechLab"};
        String Pattern = "HT";
        Video_49_Camel_Case_Pattern_Matching a = new Video_49_Camel_Case_Pattern_Matching();
        System.out.println(a.CamelCase(n, Dictionary, Pattern));
    }
}
//8
//        Hi Hello HelloWorld HiTech HiGeek HiTechWorld HiTechCity HiTechLab
//        H
//
//
//
//        Its Correct output is:
//
//        Hi Hello HiGeek HiTech HiTechCity HiTechLab HiTechWorld HelloWorld
//
//
//
//        And Your Code's output is:
//
//        Hello HelloWorld Hi HiGeek HiTech HiTechCity HiTechLab HiTechWorld


//
//    Your Output:
//        Hi Hello HiGeek HiTech HiTechLab HelloWorld HiTechCity HiTechWorld
//
//        Expected Output:
//        Hi Hello HiGeek HiTech HiTechCity HiTechLab HiTechWorld HelloWorld