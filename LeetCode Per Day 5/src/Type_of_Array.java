public class Type_of_Array {
    static class pair {
        long first, second;

        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    static pair maxNtype(long arr[], long n) {
        long max = Long.MIN_VALUE;
        for (long ele : arr)
            max = Math.max(max,ele);
        if(ascending(arr))
            return new pair(max,1);
        else if(descending(arr))
            return new pair(max,2);
        else if (arr[0] < arr[arr.length-1] )
            return new pair(max,3);
        return new pair(max,4);

    }
    static boolean ascending(long[] arr){
        for (long i=0;i<arr.length-1;i++)
            if(arr[(int)i] > arr[(int) (i+1)])
                return false;
        return true;
    }
    static boolean descending(long[] arr){
        for (long i=0;i<arr.length-1;i++)
            if(arr[(int)i] < arr[(int) (i+1)])
                return false;
        return true;
    }
}
