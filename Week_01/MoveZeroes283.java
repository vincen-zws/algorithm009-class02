public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        step(nums);
//        DobIndex(nums);
    }

    public void step (int[] nums) {
        int stepSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                stepSize++;
            }else{
                swap(nums,i,i-stepSize);
            }
        }
    }

    public void DobIndex (int[] nums) {
        for (int i = 0 , j = 0; i < nums.length ; i++) {
            if (nums[i] != 0) {
                swap(nums,i,j);
                j++;
            }
        }
    }

    public void swap(int[] nums,int i,int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
