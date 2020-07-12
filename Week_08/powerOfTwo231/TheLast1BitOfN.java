package powerOfTwo231;

import java.util.LinkedList;
import java.util.Queue;

public class TheLast1BitOfN {
    public boolean isPowerOfTwo(int n) {
        return n<=0 ? false : (n&(n-1)) == 0;

    }
    public int[][] merge(int[][] intervals) {
        Queue<int[]> result = new LinkedList<int[]>();
        for(int[] a : intervals){
            result.offer(a);
        }
        boolean flag = true;
        for(int i = 0;i<intervals.length && flag;++i){
            int[] a = result.remove();
            flag = false;
            for(int j = 0 ; j<result.size()&& !flag;++j){
                int[] standby = result.peek();
                if(standby[0]<= a[0] && standby[1] >= a[0]){
                    result.remove();
                    result.offer(m(a,standby));
                    flag = true;
                    break;
                }
                if(a[0]<= standby[0] && a[1] >= standby[0]){
                    result.remove();
                    result.offer(m(a,standby));
                    flag = true;
                    break;
                }

            }
        }
        int[][] r = new int[result.size()][2];
        for(int i = 0 ; i < r.length ; ++i) {
            r[i] = result.remove();
        }
        return r;
    }
    public static int[] m(int[] a , int[] b){
        return new int[]{Math.min(a[0],b[0]),Math.max(a[1],b[1])};
    }
}
