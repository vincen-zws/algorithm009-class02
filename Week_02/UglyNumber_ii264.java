import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class UglyNumber_ii264 {
    int initCapacity = 1690;
    int[] ulgyNums = new int[initCapacity];
    int ulgySize = 0;
    HashSet<Integer> set = new HashSet<>();
    public int nthUglyNumber(int n) {
        if (this.ulgySize < n) {
        //myself
//        _func1Loop(1690);
        //solution
//         _func2MinHeap(initCapacity);
        _func3Dynamic(initCapacity);
        }
        System.out.println(Arrays.toString(this.ulgyNums));
        return ulgyNums[n-1];
    }

    private void _func3Dynamic(int initCapacity) {
if(true) {
    int i2 = 0 , i3 = 0 , i5 = 0;
    this.ulgyNums[this.ulgySize++] = 1;
    while (this.ulgySize < initCapacity) {
        int num2 = this.ulgyNums[i2] * 2;
        int num3 = this.ulgyNums[i3] * 3;
        int num5 = this.ulgyNums[i5] * 5;

        if (num2 <= num3 && num2 <= num5) {
            this.ulgyNums[this.ulgySize] = num2;
            i2++;
        }
        if (num3 <= num2 && num3 <= num5) {
            this.ulgyNums[this.ulgySize] = num3;
            i3++;
        }
        if(num5 <= num2 && num5 <= num3) {
            this.ulgyNums[this.ulgySize] = num5;
            i5++;
        }
        this.ulgySize++;
    }
    }

if(false) {
    this.ulgyNums[0] = 1;
    int ugly, i2 = 0, i3 = 0, i5 = 0;

    for (int i = 1; i < 1690; ++i) {
        ugly = Math.min(Math.min(this.ulgyNums[i2] * 2, this.ulgyNums[i3] * 3), this.ulgyNums[i5] * 5);
        this.ulgyNums[i] = ugly;

        if (ugly == this.ulgyNums[i2] * 2) ++i2;
        if (ugly == this.ulgyNums[i3] * 3) ++i3;
        if (ugly == this.ulgyNums[i5] * 5) ++i5;
    }
}
    }

    private void _func2MinHeap(int n) {

        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        while (this.ulgySize < n) {
            long num = heap.remove();
            if (this.set.contains((int)num)) continue;
            Long mul2 = num * 2 , mul3 = num * 3 , mul5 = num * 5;
            this.ulgyNums[this.ulgySize++] = (int)num;
            this.set.add((int)num);
            heap.offer(mul2);
            heap.offer(mul3);
            heap.offer(mul5);
        }


    }

    private void  _func1Loop(int n) {
        this.ulgyNums = new int[n];
        for (int i = 1; this.ulgySize < n ; i++) {
             if(judgeUlgyNum(i)) this.ulgyNums[this.ulgySize++] = i;
        }
    }

    private boolean judgeUlgyNum(int i) {
        if(i == 1) return true;
        if(i == 0) return false;
        int modNum = i;
        while ( modNum % 2 == 0) modNum = modNum / 2;
        while ( modNum % 3 == 0) modNum = modNum / 3;
        while ( modNum % 5 == 0) modNum = modNum / 5;
        return modNum == 0;
    }

    public static void main(String[] args) {
        UglyNumber_ii264 uglyNumber_ii264  = new UglyNumber_ii264();
        System.out.println(uglyNumber_ii264.nthUglyNumber(1365));
    }
}
