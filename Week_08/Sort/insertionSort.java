package Sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class insertionSort {
    public static void insertSort(int[] a , int n){
        if ( n <= 1) return;
        int[] result = new int[]{1,2};


        for (int i = 1; i < n - 1; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j>= 0; --j) {
                if(a[j] <= value) break;
                a[j+1] = a[j];
            }
            a[j+1] = value;
        }
    }
    public static void main(String[] args) {
        int size = 2;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
        insertSort(a,size);
        System.out.println(Arrays.toString(a));
    }

}
