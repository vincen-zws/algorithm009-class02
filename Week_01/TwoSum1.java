import java.util.HashMap;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
//        return _func1unc1DouLoop(nums,target);
//        return _func2HashMap(nums,target);

        return _func2HashMapOnece(nums,target);
    }

    private int[] _func2HashMapOnece(int[] nums, int target) {
        HashMap<Integer,Integer> valAndIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (valAndIndex.containsKey(result)) {
                return new int[] {valAndIndex.get(result) , i};
            }
            valAndIndex.put(nums[i],i);
        }
        return null;
    }


    private int[] _func2HashMap(int[] nums, int target) {
        HashMap<Integer,Integer> valAndIndex = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            valAndIndex.put(nums[i],i);
        }
        for (int i = 0; i < nums.length - 1 ; i++) {
            int result = target - nums[i];
            if (valAndIndex.containsKey(result) && valAndIndex.get(result) != i) {
                int[] a = {i, valAndIndex.get(result)};
                return a;

            }
        }
        return null;
    }

    private int[] _func1DouLoop(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int one = nums[i];
            int result = target - one;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == result) {
                    int[] a = {i,j};
                    return a;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        TwoSum1 t = new TwoSum1();
        System.out.println(t.twoSum(a, 11));
    }

}
