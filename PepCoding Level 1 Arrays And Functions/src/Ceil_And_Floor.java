public class Ceil_And_Floor {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        ceilAndFloor(arr, 56);
    }
    // https://www.youtube.com/watch?v=qaQRRWXgFIQ&list=PL-Jc9J83PIiHOV7lm2uSw4ZiVsIRsGS6r&index=41
    public static void ceilAndFloor(int[] arr, int x) {
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;
        int s = 0;
        int e = arr.length;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (x < arr[mid]) {
                ceil = arr[mid];
                e = mid - 1;
            } else if (x > arr[mid]) {
                floor = arr[mid];
                s = mid + 1;
            } else {
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }
        System.out.println(floor+"  "+ceil);
        return;
    }
}
