import java.util.Arrays;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            result[i] = arrayMaxValue(nums,i,i + k);
        }
        return result;
    }
    private int arrayMaxValue(int[] nums , int start , int end) {
        int max = nums[start];
        for (int i = start + 1; i < end; i++) {
            max = nums[i] > max ? nums[i] : max;
        }
        return max;
    }
    public static void main(String[] args) {
        SlidingWindowMaximum239 s =  new SlidingWindowMaximum239();
        int [] a = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(s.maxSlidingWindow(a, 3)));
    }
}
