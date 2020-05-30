package review;

public class RemoveDuplicates26_3 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        return _func1DouIndex(nums);
//        return _func2StepCount(nums);
    }

    private int _func2StepCount(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[i - count] = nums[i];
            } else {
                count++;
            }
        }
        return nums.length - count;
    }

    private int _func1DouIndex(int[] nums) {
        int uniqIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqIndex]) {
                nums[++uniqIndex] = nums[i];
            }
        }
        return uniqIndex + 1;

    }
}
