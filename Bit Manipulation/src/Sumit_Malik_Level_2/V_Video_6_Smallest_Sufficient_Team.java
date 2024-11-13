package Sumit_Malik_Level_2;

import java.util.*;

public class V_Video_6_Smallest_Sufficient_Team {
//    public static void main(String[] args) {
//
//
//        String[] req_skills = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
//        String[][] people = {
//                {"algorithms", "math", "java"},
//                {"algorithms", "math", "reactjs"},
//                {"java", "csharp", "aws"},
//                {"reactjs", "csharp"},
//                {"csharp", "math"},
//                {"aws", "java"}
//        };
//        List<List<String>> peo = new ArrayList<>();
//
//        for (int i = 0; i < people.length; i++) {
//            List<String> list = new ArrayList<>();
//            for (int j = 0; j < people[i].length; j++)
//                list.add(people[i][j]);
//            peo.add(list);
//        }
//        System.out.println(Arrays.toString(smallestSufficientTeam(req_skills, peo)));
//
//    }
//
//    static class Pair {
//        String st;
//        HashSet<Integer> set;
//
//        public Pair(String st, HashSet<Integer> set) {
//            this.st = st;
//            this.set = set;
//        }
//    }
//
//    static List<Integer> list ;
//    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
//        list = new ArrayList<>();
//        HashMap<String, HashSet<Integer>> map = new HashMap<>();
//        for (String skill : req_skills) {
//            HashSet<Integer> set = new HashSet<>();
//            for (int i = 0; i < people.size(); i++) {
//                for (String str : people.get(i)) {
//                    if (str.equals(skill)) {
//                        set.add(i);
//                    }
//                }
//            }
//            map.put(skill, set);
//        }
//
//        Pair[] arr = new Pair[map.size()];
//        int k = 0;
//        for (String s : map.keySet()) {
//            arr[k++] = new Pair(s, map.get(s));
//        }
//
//        findMinimum(arr,0,new HashSet<Integer>());
//        int[] res = new int[list.size()];
//        int i=0;
//        for (int val : list){
//            res[i++] = val;
//        }
//        return res;
//    }
//    public static void findMinimum(Pair[] arr,int index,HashSet<Integer> temp){
//        if(index == arr.length){
//
//
//            if(temp.size() < list.size() || list.size() == 0){
//                list = new ArrayList<>(temp);
//            }
//
//            return;
//        }
//
//        for (int val : arr[index].set){
//            if(temp.contains(val)){
//                findMinimum(arr,index+1,temp);
//            }else {
//                temp.add(val);
//                findMinimum(arr,index+1,temp);
//                temp.remove(val);
//            }
//        }
//    }

    // https://leetcode.com/problems/smallest-sufficient-team/submissions/


    static  ArrayList<Integer> solution;
    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        solution = new ArrayList<>();
        int n = req_skills.length;
        HashMap<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillMap.put(req_skills[i], i);
        }


        int[] peo = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {

            for (int j = 0; j < people.get(i).size(); j++) {
                String skill = people.get(i).get(j);
                int skillNum = skillMap.get(skill);
                peo[i] = peo[i] | (1 << skillNum);
            }
        }


        solution(peo, n, 0, new ArrayList<>(),0);
        System.out.println(solution.size());
        int i = 0;
        int[] res = new int[solution.size()];
        for (int val : solution)
            res[i++] = val;
        System.out.println(Arrays.toString(res));
        return res;
    }
    public static void solution(int[] people, int numberSkills, int index, ArrayList<Integer> currSolution, int skills) {
        if (index == people.length) {
            if (skills == ((1 << numberSkills) - 1)) {
                if (currSolution.size() < solution.size() || solution.size() == 0) {
//                    System.out.println(solution +"   "+currSolution);
                    solution = new ArrayList<>(currSolution);
//                    System.out.println(solution +"   "+currSolution);
//                    System.out.println("\n");
                }
            }
            return;
        }
        solution(people, numberSkills, index + 1, currSolution, skills);
        currSolution.add(index);
        solution(people, numberSkills, index + 1, currSolution,  (skills | people[index]));
        currSolution.remove(currSolution.size() - 1);
    }

    public static void main(String[] args) {
        String[] arr = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        String[][] matrix = {
                {"algorithms", "math", "java"},
                {"algorithms", "math", "reactjs"},
                {"java", "csharp", "aws"},
                {"reactjs", "csharp"},
                {"csharp", "math"},
                {"aws", "java"}
        };

        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            List<String> list1 = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                list1.add(matrix[i][j]);
            }
            list.add(list1);
        }
        System.out.println(Arrays.toString(smallestSufficientTeam(arr, list)));
    }
}
