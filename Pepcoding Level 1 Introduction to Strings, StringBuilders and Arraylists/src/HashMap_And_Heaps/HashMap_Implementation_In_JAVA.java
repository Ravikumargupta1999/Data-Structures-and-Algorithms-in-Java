package HashMap_And_Heaps;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap_Implementation_In_JAVA {

    public static class HashMap<K, V> {        //1
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {  //2
            initializeBuckets(4);
            size = 0;
        }

        private void initializeBuckets(int N) {  //3
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        public void put(K key, V value) throws Exception {
            int bi = hashFuction( key);
            int di = getIndexWithinBucket(key,bi);
            if(bi != -1)
            {
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }
            else
            {
                HMNode node = new HMNode(key,value);
                buckets[bi].add(node);
                size++;
            }
            double lambda = size *1.0 / buckets.length;
            if(lambda > 2.0)
                rehash();
        }
        public void rehash() throws Exception {
            LinkedList<HMNode>[] oba = buckets;
            initializeBuckets(oba.length*2);
            size = 0;
            for(int i=0;i<oba.length;i++)
            {
                for(HMNode node : oba[i])
                {
                    put(node.key,node.value);
                }
            }
        }

        public int hashFuction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        public int getIndexWithinBucket(K key, int bi) {
            int di = 0;
            for (HMNode node : buckets[bi]) {
                if (node.key.equals(key))
                    return di;
                di++;
            }
            return -1;
        }

        private V get(K key) throws Exception {
            int bi = hashFuction(key);
            int di = getIndexWithinBucket(key, bi);
            if (di != -1) {
                HMNode node = buckets[bi].get(di);
                return node.value;
            } else
                return null;
        }

        public boolean containsKey(K key) {
            int bi = hashFuction(key);
            int di = getIndexWithinBucket(key, bi);
            if (di != -1) {

                return true;
            } else
                return false;
        }
        public V remove(K key) throws Exception{
            int bi = hashFuction(key);
            int di = getIndexWithinBucket(key,bi);
            if(di != -1)
            {
                HMNode node = buckets[bi].get(di);
                size--;
                return node.value;
            }
            else
            {
                return null;
            }
        }
        public ArrayList<K> keySet() throws Exception {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (HMNode node : buckets[i])
                    keys.add(node.key);
            }
            return keys;
        }
        public int size()
        {
            return size;
        }
        public void display()
        {
            System.out.println("Display Begins");
            for(int bi=0;bi < buckets.length;bi++)
            {
                System.out.print("Bucket"+bi+" ");
                for(HMNode node : buckets[bi])
                {
                    System.out.print(node.key+"@"+node.value+" ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }
}
