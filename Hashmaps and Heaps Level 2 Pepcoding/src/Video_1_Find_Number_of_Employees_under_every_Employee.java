import java.util.HashMap;
import java.util.HashSet;

public class Video_1_Find_Number_of_Employees_under_every_Employee {
    public static void findCount(HashMap<String, String> map) {
        HashMap<String, HashSet<String>> tree = new HashMap<>();
        String ceo = "";
        for (String emp : map.keySet()) {
            String man = map.get(emp);

            if (man.equals(emp))
                ceo = man;
            else {
                if (tree.containsKey(man)) {
                    HashSet<String> employees = tree.get(man);
                    employees.add(emp);
                } else {
                    HashSet<String> employees = new HashSet<>();
                    employees.add(emp);
                    tree.put(man, employees);
                }
            }
        }
        System.out.println(tree);

        HashMap<String, Integer> results = new HashMap<>();
        getSize(tree, ceo, results);
        for (String emp : results.keySet()) {
            System.out.println(emp + " " + results.get(emp));
        }
    }

    public static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String, Integer> result) {
        if (!tree.containsKey(man)) {
            result.put(man, 0);
            return 1;
        }
        int size = 0;
        for (String emp : tree.get(man)) {
            int cs = getSize(tree, emp, result);
            size += cs;
        }
        result.put(man, size);
        return size + 1;
    }

    public static void main(String[] args) {
        HashMap<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
        findCount(dataSet);


    }
}
