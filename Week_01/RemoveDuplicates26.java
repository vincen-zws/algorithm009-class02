import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {

        //自己做的，没看到是已经排序的
//        return _fun1HashSet(nums);
//        return _fun2Sort(nums);

        //看的题解
//        return _fun3TwoIndex(nums);
        return _fun4StepLength(nums);
    }

    private int _fun4StepLength(int[] nums) {
        if(nums.length < 2 )  return nums.length;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) nums[i-count] = nums[i];
            else ++count;
        }
        return nums.length - count;

    }

    private int _fun3TwoIndex(int[] nums) {
        if(nums.length < 2 )  return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

    private int _fun1HashSet(int[] nums) {
        //结果是正确的，但是要排序
        HashSet<Integer> set = new HashSet<>();
        int tail = nums.length - 1 ;
        for (int i = 0; i <= tail; ++i) {
            if(set.contains(nums[i])){
                moveTail(nums,i,tail--);
                --i;
            } else  {
                set.add (nums[i]);
            }
            System.out.println(Arrays.toString(nums ));
        }
        Arrays.sort(nums,0,tail + 1);
        System.out.println(Arrays.toString(nums ));
        return tail + 1;
    }

    private int _fun2Sort(int[] nums) {
        if( nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int uniqElem = nums[0];
        int tail = nums.length;
        for (int i = 1 ; i < tail ; ++i) {
            if(nums[i] == uniqElem ) {
                System.out.println("remove " + i);
                remove(nums,i--);
                tail--;
            } else {
                uniqElem = nums[i];
            }
            System.out.println(Arrays.toString(nums ) + "\t" + uniqElem)  ;
        }
        return tail;
    }

    private void remove(int[] nums , int removeIndex) {
        for (int i = removeIndex; i < nums.length-1; i++) {
            nums[i] = nums[i+1];
        }
    }

    private void moveTail(int[] nums, int i, int tail) {
        int temp = nums[i];
        nums[i] = nums[tail];
        nums[tail] = temp;
    }

    public static void main(String[] args) {
        int [] a = {4, 5, 5 ,6 ,6,7};
        RemoveDuplicates26 removeDuplicates26 = new RemoveDuplicates26();
        System.out.println(removeDuplicates26.removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }

}
