import java.util.Arrays;

public class PlusOne66 {
    public int[] plusOne(int[] digits) {
//        return  _func1ReverseIterate(digits);
    return _func2ReverseIterateImprove(digits);
    }

    private int[] _func2ReverseIterateImprove(int[] digits) {

        for (int i = digits.length -1; i >= 0 ; --i) {
            if (digits[i] <= 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;

    }

    private int[] _func1ReverseIterate(int[] digits) {

        for (int i = digits.length -1; i >= -1 ; --i) {
            if(i < 0) {
                int[] result = new int[digits.length+1];
                result[0] = 1;
                System.arraycopy(digits,0,result,1,digits.length);
                return result;
            } else if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        return digits;
    }



    public static void main(String[] args) {
        PlusOne66 plusOne66 = new PlusOne66();
        System.out.println(Arrays.toString(plusOne66.plusOne(new int[]{9,9,9,9,9,9})));
    }
}
