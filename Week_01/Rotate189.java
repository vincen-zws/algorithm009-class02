import java.util.*;

public class Rotate189 {
    public void rotate(int[] nums, int k) {
        int rotate = k % nums.length;
        if(rotate != 0){

//            _func1QueueCache(nums,rotate);
//            _func2CycleSwap(nums,rotate);
            _func3TriReverse(nums,rotate);
        }
    }

    private void _func3TriReverse(int[] nums, int k) {
        reverse(nums,0,nums.length);
        reverse(nums,0,k);
        reverse(nums,k,nums.length);
    }

    private void reverse(int[] nums, int start, int end) {
        int i = start , j = end -1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            ++i;
            --j;
        }
    }

    private void _func2CycleSwap(int[] nums, int k) {
        int count = 0;
        for (int start = 0; count < nums.length; ++start) {
            int current = start;
            int prev = nums[current];
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                ++count;
            }while (start != current);
        }
    }



    private void _func1QueueCache(int[] nums, int k) {
        Queue<Integer> cache = new ArrayDeque<Integer>();
//        int queueSize = 0; 便于理解
//        int queueCapacity = k+1;
        for (int i = 0; i < nums.length; i++) {
            cache.offer(nums[i]);
//            queueSize++;
//            if(queueSize>=queueCapacity)
            if (i >= k) {
               nums[i] = cache.poll();
//               queueSize--;
            }
        }
        for (int i = 0; i < k; i++) {
            nums[i] = cache.poll();
        }
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        Rotate189 rotate189 = new Rotate189();
        rotate189.rotate(a,3);
        System.out.println(Arrays.toString(a));
    }
}
