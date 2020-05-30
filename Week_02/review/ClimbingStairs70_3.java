package review;

import java.util.HashMap;

public class ClimbingStairs70_3 {
    public int climbStairs(int n) {
//        return _func1HashMapCache(n);
//        return _func2ListCache(n);
//        return _func3Dynamic(n);
//        return _func4TowNum(n);
        return _func5FibonacciFormula(n);
    }

    private int _func5FibonacciFormula(int n) {
        double sqrt5 = Math.sqrt(5);
        double finb = Math.pow( (1 + sqrt5) / 2 , n + 1 ) - Math.pow((1 - sqrt5) / 2 , n + 1);
        return (int) (finb / sqrt5);
    }

    private int _func4TowNum(int n) {
        int index = 1;
        int indexLeft = 1;
        for (int i = 2; i <= n ; i++) {
            int result = index + indexLeft;
            indexLeft = index;
            index = result;
        }
        return index;
    }

    private int _func3Dynamic(int n) {
        int[] dynamic = new int[n + 1];
        dynamic[0] = 1;
        dynamic[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dynamic[i] = dynamic[i - 1] + dynamic[i - 2];
        }
        return dynamic[n];
    }

    private int _func2ListCache(int n) {
        int [] starisAndCouhnt = new int[n];

        return _func2Recursive(n,starisAndCouhnt);
    }

    private int _func2Recursive(int n, int[] starisAndCouhnt) {
        if(n < 0) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        if(starisAndCouhnt[n] > 0) {
            return starisAndCouhnt[n];
        }

        return _func2Recursive(n-1 , starisAndCouhnt) + _func2Recursive(n-2 , starisAndCouhnt);
    }

    private int _func1HashMapCache(int n) {
        HashMap<Integer,Integer> starisAndCount = new HashMap<>();
        return _func1Recursive(n,starisAndCount);
    }

    private int _func1Recursive(int n , HashMap<Integer , Integer> sAndC) {

        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if( sAndC.containsKey(n) ) {
            return sAndC.get(n);
        }

        return _func1Recursive(n-1 , sAndC) + _func1Recursive(n-2 , sAndC);
    }


}
