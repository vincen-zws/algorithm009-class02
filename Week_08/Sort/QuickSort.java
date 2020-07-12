package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] a ,int begin ,int end){
        if(begin >= end) return;

        int pivot = partition(a,begin,end);
        quickSort(a,begin,pivot-1);
        quickSort(a,pivot+1,end);
    }

    private static int partition(int[] a, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i <= end; i++) {
            if(a[i]<a[pivot]){
                int temp = a[i];
                a[i] = a[counter];
                a[counter] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }
    public static void main(String[] args) {
        int size = 1;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
        quickSort(a,0,size-1);
        System.out.println(Arrays.toString(a));

            int n = -3;
             int c =0 ; // 计数器
            for (c =0; n!=0; n >>=1) // 循环移位
                c += n &1 ; // 如果当前位是1，则计数器加1
        System.out.println(c);

    }
    public static String toS(int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(n&1);
            n=n>>1;
        }
        return sb.toString();
    }

}
