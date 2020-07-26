package CoinChange322;

import java.util.ArrayList;
import java.util.Arrays;

public class DPArrayLoopDFS {

    public int coinChange(int[] coins, int amount) {
        return dfs(coins,amount);
    }

    private int dfs(int[] coins, int amount) {
        if(amount == 0 )return 0;
        if(amount < 0 )return -1;
        int[] cache = new int[amount+1];
        int max = amount +1;
        Arrays.fill(cache,max);
        cache[0]=0;
        int am = max ;
        for(int c :coins) am = Math.min(c,am);
        System.out.println(am);
        for(; am < amount +1 ;++am){
            for(int c : coins){
                int subAm = am  - c;
                if(subAm >= 0 ) {
                    cache[am] = Math.min(cache[am] ,  cache[subAm] +1);
                }
                System.out.println(cache[am]);
            }
        }
        return cache[amount]==amount+1 ? -1 : cache[amount];
    }
    public static void main(String[] args) {
        DPArrayLoopDFS nn = new DPArrayLoopDFS();
        System.out.println(nn.coinChange(new int[]{1,2,5}, 11));

    }
}
