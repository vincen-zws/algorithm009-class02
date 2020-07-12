package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] a, int left , int right){
        if(left >= right) return ;

        int mid = left + ((right - left) >>1 );
        mergeSort(a,left,mid);
        mergeSort(a,mid+1,right);
        merge(a,left,mid,right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] tempMerge = new int[right - left + 1];
        int i = left , j = mid + 1;
        int tempIndex =  0;
        while(i <= mid && j <= right){
            tempMerge[tempIndex++] = a[i] <= a[j] ? a[i++] : a[j++];
        }
        while(i <= mid) tempMerge[tempIndex++] = a[i++];
        while(j <= right) tempMerge[tempIndex++] = a[j++];

        for (int k = 0; k < tempMerge.length; k++) {
            a[left+k] = tempMerge[k];
        }

    }
    public static void main(String[] args) {
        int size = 2;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
        mergeSort(a,0,size-1);
        System.out.println(Arrays.toString(a));
    }
}
