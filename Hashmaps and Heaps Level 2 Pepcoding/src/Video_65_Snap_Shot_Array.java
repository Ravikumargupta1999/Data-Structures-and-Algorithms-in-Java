import java.util.HashMap;

// https://leetcode.com/problems/snapshot-array/submissions/
// https://www.youtube.com/watch?v=DOHvkZ7QpAM&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=65
public class Video_65_Snap_Shot_Array {
    int sid = 0;
    HashMap<Integer, Integer>[] maps;

    public Video_65_Snap_Shot_Array(int length) {
        maps = new HashMap[length];
        for (int i = 0; i < length; i++) {
            maps[i] = new HashMap<>();
        }
    }

    public void set(int index, int val) {
        maps[index].put(sid, val);
    }

    public int snap() {
        sid++;
        return sid - 1;
    }

    public int get(int index, int snap_id) {
        while (snap_id >= 0 && !maps[index].containsKey(snap_id)) {
            snap_id--;
            if (snap_id == -1)
                return 0;
        }
        return maps[index].get(snap_id);

    }
}
