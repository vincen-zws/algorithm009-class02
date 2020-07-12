package numberOf1Bits191;

public class TheLast1BitOfN {
    public static int hammingWeight(int n) {
        int count = 0;
        while(n!=0) {
            n = n&(n-1); //干掉2进制序列中最后一个1
            count++;
        }
        return count;
    }
}
