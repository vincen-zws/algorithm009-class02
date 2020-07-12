package Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] a ,int n){
        if(n <= 1) return;

        for (int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }
    public static void main(String[] args) {
        int size = 10;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
        bubbleSort(a,size);
        System.out.println(Arrays.toString(a));
    }
}
