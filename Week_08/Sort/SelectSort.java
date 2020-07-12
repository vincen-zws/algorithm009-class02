package Sort;

import java.util.Arrays;

public class SelectSort {
    public static void selectionSort(int[] a, int n) {
        if(n <= 1) return;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] =  temp;
        }
    }

    public static void main(String[] args) {
        int size = 2;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
        selectionSort(a,size);
        System.out.println(Arrays.toString(a));
    }
}
