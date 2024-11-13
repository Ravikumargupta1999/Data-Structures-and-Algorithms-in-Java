package Biweekly_Contest_68;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Find_All_Possible_Recipes_From_Given_Supplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        HashSet<String> available = new HashSet<>();
        for (String s : supplies)
            available.add(s);

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < recipes.length; i++)
            set.add(i);
        while (true) {
            boolean flag = false;
            HashSet<Integer> set1 = new HashSet<>();
            for (int i : set) {
                int j = 0;
                for (j = 0; j < ingredients.get(i).size(); j++) {

                    if (!available.contains(ingredients.get(i).get(j)))
                        break;
                }
                if (j == ingredients.get(i).size()) {
                    flag = true;
                    res.add(recipes[i]);
                    available.add(recipes[i]);
                    set1.add(i);
                }
            }
            for (int i : set1)
                set.remove(i);
            if (!flag) break;
        }
        return res;
    }
}


