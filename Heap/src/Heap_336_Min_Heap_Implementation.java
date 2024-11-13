public class Heap_336_Min_Heap_Implementation {
    // https://practice.geeksforgeeks.org/problems/operations-on-binary-min-heap/1#
    int[] arr;
    int capacity;
    int heap_size;
    Heap_336_Min_Heap_Implementation(int cap) {
        heap_size = 0;
        capacity = cap;
        arr = new int[cap];
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void minHeapify(int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest;
        if (left < n && arr[left] < arr[i])
            smallest = left;
        else
            smallest = i;
        if (right < n && arr[right] < arr[smallest])
            smallest = right;
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(n, smallest);
        }
    }

    public int extractMin() {
        if (heap_size < 1)
            return -1;
        int min = arr[0];
        arr[0] = arr[heap_size - 1];
        heap_size -= 1;
        minHeapify(heap_size, 0);
        return min;
    }

    public void insertKey(int val) {
        heap_size += 1;
        arr[heap_size - 1] = val;
        int i = heap_size - 1;
        while (i > 0 && arr[i] < arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    void deleteKey(int i) {
        if (i < 0 || i >= heap_size)
            return;
        decreaseKey(i,Integer.MIN_VALUE);
        extractMin();
    }
    void decreaseKey(int i,int val){
        arr[i] = val;
        while (i > 0 && arr[i] < arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void main(String[] args) {
        String[] st1 = "573 995 224 22 134 550 102 200 466 263 483 470 564 264 155 494 827 694 854 505 117 116 513 70 109 290 460 283 697 724 8 155 636 80 385 12 863 739 779 36 355 264 436 512 539 641 63 294 301 684 988 238 144 450 229 956 18 753 345 681 281 277 849 425 680 374 369 431 836 199 289 454 184 32 128 914 678 803 257 178 319 292 813 41 224 120 349 562 106 123 24 485 96 373 725 153 929 827 837 88 613 930 312 576 284 56 250 243 686 278 2 782 31 105 111 907 343 174 476 169 577 727 181 421 115 118 45 101 89 148 717 427 560 800 29 594 383 490 370 93 849 483 335 17 53 815 991 203 639 230 698 281 471 504 515 365 706 930 634 809 299 607 95 254 580 661 713 22 831 899 201 928 548 604 824 579 349 58 812 268 393 271 350 613 917 443 275 779 36 154 873 870 321 259 642 266 423 970 541 16 710 285 382 419 475 769 494 129 842 73 424 441 569 986 363 337 409 806".split(" ");
        System.out.println(st1.length);
        String[] st2 = "573 995 224 22 134 550 102 200 402 263 483 470 564 264 155 494 827 694 854 505 117 116 513 70 109 290 460 283 697 724 8 155 636 80 385 12 863 739 779 36 355 264 436 512 539 641 63 294 301 684 988 238 144 450 229 956 18 753 345 681 281 277 849 425 680 374 369 431 836 199 289 454 184 32 128 914 678 803 257 178 319 292 813 41 224 120 349 562 106 123 24 485 96 373 725 153 929 827 837 88 613 930 312 576 284 56 250 243 686 278 2 782 31 105 111 907 343 174 476 169 577 727 181 421 115 118 45 101 89 148 717 427 560 800 29 594 383 490 370 93 849 483 335 17 53 815 991 203 639 230 698 281 471 504 515 365 706 930 634 809 299 607 95 254 580 661 713 22 831 899 201 928 548 604 824 579 349 58 812 268 393 271 350 613 917 443 275 779 36 154 873 870 321 259 642 266 423 970 541 16 710 285 382 419 475 769 494 129 842 73 424 441 569 986 363 337 409 806".split(" ");
        System.out.println(st2.length);
        for(int i=0;i<st1.length;i++)
        {
            if(st1[i].compareTo(st2[i]) != 0){
                System.out.println(i+"  "+st1[i]+"   "+st2[i]);
            }
        }
    }

}
