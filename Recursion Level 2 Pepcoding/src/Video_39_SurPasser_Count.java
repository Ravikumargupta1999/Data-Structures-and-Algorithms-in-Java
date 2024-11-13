import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/surpasser-count0615/1
public class Video_39_SurPasser_Count {
    // Brute Force
    int[] findSurPasser1(int[] arr, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                count = arr[j] > val ? count +1 : count;
            }
            ans[i] = count;
        }
        return ans;
    }

    static HashMap<Integer, Integer> map = new HashMap();

    static int[] inversionCount(int arr[], int n) {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++)
            map.put(arr[i], 0);
        int count = mergeSort(arr, temp, 0, n - 1);
        for (int i = 0; i < temp.length; i++)
            temp[i] = map.get(arr[i]);
        return temp;

    }

    public static int mergeSort(int[] arr, int[] temp, int l, int r) {
        int inv = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            inv += mergeSort(arr, temp, l, mid);
            inv += mergeSort(arr, temp, mid + 1, r);
            inv += merge(arr, temp, l, mid + 1, r);

        }
        return inv;
    }

    public static int merge(int[] arr, int[] temp, int l, int mid, int r) {
        int i, j, k, inv = 0;
        i = l;
        j = mid;
        k = l;
        while (i <= mid - 1 && j <= r) {
            if (arr[(int) i] <= arr[(int) j]) {
                temp[(int) k++] = arr[(int) i++];
            } else {
                map.put(temp[k], map.get(temp[k]) + mid - i);
                temp[(int) k] = arr[(int) j];
//                {
//                    map.put(temp[k],map.get(temp[k])+mid-i);
////                    inv += (mid - i);
//                }
                k++;
                j++;
            }
        }
        while (i <= mid - 1) {
            temp[(int) k++] = arr[(int) i++];
        }
        while (j <= r) {
            temp[(int) k++] = arr[(int) j++];
        }
        for (int d = l; d <= r; d++)
            arr[(int) d] = temp[(int) d];
        return inv;

    }

    public static void main(String[] args) {
        int[] arr = {4,6,3,9,7,10};
        System.out.println(inversionCount(arr,arr.length));
    }

}

