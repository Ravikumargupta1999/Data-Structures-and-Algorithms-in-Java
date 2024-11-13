package Weekly_Contest_323;

import java.util.Arrays;

public class Design_Memory_Allocator {
    // https://www.youtube.com/watch?v=ZvSThiksf8c
    class Allocator {
        int n;
        int[] arr;

        public Allocator(int n) {
            arr = new int[10002];
            Arrays.fill(arr, -1);
            this.n = n;
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == -1) {
                    int len = 0;
                    int j = i;
                    while (i < n && arr[i] == -1 && len < size) {
                        ++len;
                        ++i;
                    }

                    if (len == size) {
                        int ret = j;
                        while (j < i) {
                            arr[j++] = mID;
                        }
                        return ret;
                    }
                }
            }
            return -1;
        }

        public int free(int mID) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] == mID){
                    count++;
                    arr[i] = -1;
                }
            }
            return count;
        }
    }
}
