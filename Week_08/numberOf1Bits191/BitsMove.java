package numberOf1Bits191;

public class BitsMove {
    //移动mask 0000010000
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32 ; i++) {
            if( (n&mask) == 1) count++;
            mask <<= 1;
        }
        return count;
    }

    //移动n
    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32 ; i++) {
            count += n&1;
            n >>= 1;
        }
        return count;
    }

//    移动n进化
    public int hammingWeight3(int n) {
        int count = 0;
        while (n!=0) {
            count += n&1;
            n >>>= 1;
        }
        return count;
    }
}
