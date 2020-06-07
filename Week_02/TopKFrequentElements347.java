import java.util.List;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        //myself
//        return _func1HashMapSort(nums,k);
//        return _func2HashMapMinHeap(nums,k);
        return _func3HashMapMaxHeap(nums,k);
    }

    private int[] _func3HashMapMaxHeap(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i,0);
            map.put(i,map.get(i)+1);
        }
        PriorityQueue<Map.Entry<Integer , Integer>> heap =  new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer , Integer> e : map.entrySet()) {
            heap.offer(e);
        }
        int [] result = new int[k];
        for (int i = 0; i < k ; i++) {
            result[i] = heap.remove().getKey();
        }
        return result;
    }
    public int[] topKFrequent1(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        int[] top_k = new int[k];
        int i = 0;
        while (!heap.isEmpty())
            top_k[i++] = (heap.poll());

        return top_k;
    }

    private int[] _func2HashMapMinHeap(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : nums) {
            if (!map.containsKey(i)) map.put(i,0);
            map.put(i,map.get(i) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {

            if (heap.size() < k) {
                heap.offer(e);
            } else {
                if(e.getValue() > heap.peek().getValue()){
                    heap.remove();
                    heap.offer(e);
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k ; i++) {
            result[i] = heap.remove().getKey();
        }
        return result;
    }

    private int[] _func1HashMapSort(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i : nums) {
            if(!map.containsKey(i)) map.put(i,0);
            map.put(i,map.get(i)+1);
        }
        Object[]  sortedArray = map.entrySet().stream().sorted((x, y)->{return y.getValue() -x.getValue();}).toArray();
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> e  = (Map.Entry<Integer,Integer>)sortedArray[i];
            result[i] = e.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements347 topKFrequentElements347 = new TopKFrequentElements347();
        System.out.println(Arrays.toString(topKFrequentElements347._func1HashMapSort(new int[]{1, 3, 4, 2, 1, 12, 3, 45, 5, 32, 2, 2, 1, 2, 34, 4, 5}, 3)));
    }
}
