package review;

import java.util.Arrays;

//第三遍
public class MoveZeroes283_3 {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1)
            return;
        
//        _func1DouIndex(nums);
        _func2StepLen(nums);
    }

    private void _func2StepLen(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[i-count] = nums[i];
                if(count != 0) {
                    nums[i] = 0;
                }
            } else {
                count++;
            }
        }
    }

    private void _func1DouIndex(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if( i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes283_3 moveZeroes283 = new MoveZeroes283_3();
        int[] a = new int[]{0,0,1,1,2,3,0,0,1,2};
        moveZeroes283.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
