package Weekly_Contest_322;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Divide_Players_Into_Teams_of_Equal_Skill {
    public long dividePlayers(int[] skill) {
        long res = 0;
        Arrays.sort(skill);
        int i = 0;
        int j = skill.length - 1;
        int prod = skill[i] + skill[j];
        while (i < j) {
            if (skill[i] + skill[j] != prod)
                return -1;
            res += (skill[i] * skill[j]);
            i++;
            j--;
        }
        return res;
    }
}
