package review;

import java.util.ArrayDeque;
import java.util.Queue;

public class Rotate189_3 {
    public void rotate(int[] nums, int k) {
        int rotate = k % nums.length;
        if(rotate != 0) {
            _func1QueueCache(nums, rotate);
            _func2CycleSwap(nums, rotate);
            _func3TirReverse(nums, rotate);
        }
    }

    private void _func3TirReverse(int[] nums, int k) {
        _arrayReverse(nums,0,nums.length);
        _arrayReverse(nums,0,k);
        _arrayReverse(nums,k,nums.length);
    }

    private void _arrayReverse(int[] nums, int start, int end) {
        --end;
        while (start < end) {
            swap(nums,start,end);
            ++start;
            --end;
        }
    }

    private void _func2CycleSwap(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length && count < nums.length; start++) {
            int current = start;
            int prev = nums[current];
            do{
                current = ( current + k ) % nums.length;
                int temp = nums[current];
                nums[current] = prev;
                prev = temp;
                count++;
;            }while(start != current);
        }
    }

    private void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void _func1QueueCache(int[] nums, int k) {
        Queue<Integer> cache = new ArrayDeque<>(k + 1);
        for (int i = 0; i < nums.length ; i++) {
            cache.offer(nums[i]);
            if (i >= k) {
                nums[i] = cache.remove();
            }
        }
        for (int i = 0; i < k ; i++) {
            nums[i] = cache.remove();
        }
    }
}
