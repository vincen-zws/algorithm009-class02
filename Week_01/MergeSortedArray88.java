import java.util.Arrays;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        _func1ArrayCopy(nums1,m,nums2,n);
        _func2TailInsert(nums1,m,nums2,n);
    }

    private void _func2TailInsert(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1 , j = n - 1 , k = m + n -1;

        while (i>=0 && j >=0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] :nums2[j--];
        }
        System.arraycopy(nums2,0,nums1,0,j+1);
    }

    public void _func1ArrayCopy(int[] nums1, int m, int[] nums2, int n) {
        int[] temp1 = new int[m];
        System.arraycopy(nums1,0,temp1,0,m);

        int i = 0 , j = 0 , index = 0;
        while (index < m + n) {
            if(j >= n || (i < m && temp1[i] < nums2[j])) {
                nums1[index++] = temp1[i++];
            } else {
                nums1[index++] = nums2[j++];
            }
        }


    }

    public static void main(String[] args) {
        int[] a = {0};
        int[] b = {2};

        MergeSortedArray88 m = new MergeSortedArray88();
        m.merge(a,0,b,1);
        System.out.println(Arrays.toString(a));
    }

}
