package letterCombinationsOfAPhoneNumber17;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class MyBacktrack_LetterCombinationsOfAPhoneNumber {
//    输入："23"
//    输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    List<String> result = new LinkedList<>();
    HashMap<Character,char[]> num2Char = new HashMap<>();
    public void initNum2Char(){
        this.num2Char.put('1',new char[0]);
        this.num2Char.put('2',new char[]{'a','b','c'});
        this.num2Char.put('3',new char[]{'d','e','f'});
        this.num2Char.put('4',new char[]{'g','h','i',});
        this.num2Char.put('5',new char[]{'j','k','l',});
        this.num2Char.put('6',new char[]{'o','m','n',});
        this.num2Char.put('7',new char[]{'p','q','r','s',});
        this.num2Char.put('8',new char[]{'t','u','v',});
        this.num2Char.put('9',new char[]{'w','x','y','z',});
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            initNum2Char();
            backtrack(new StringBuilder(), digits.toCharArray(), 0);
        }
        return result;
    }

    private void backtrack(StringBuilder board, char[] chars, int i) {
        if (i >= chars.length) {
            result.add(board.toString());
            return;
        }
        char[] numChars = num2Char.get(chars[i]);
        for (int j = 0; j < numChars.length; j++) {
            board.append(numChars[j]);
            backtrack(board, chars, i+1);
            board.deleteCharAt(board.length() - 1);
        }
    }

    private void recursive(String board, char[] chars, int i) {
        if (i >= chars.length) {
            result.add(board.toString());
            return;
        }
        char[] numChars = num2Char.get(chars[i]);
        for (int j = 0; j < numChars.length; j++) {
            recursive(board + numChars[j], chars, i+1);
        }
    }

    public static void main(String[] args) {
        MyBacktrack_LetterCombinationsOfAPhoneNumber myBacktrackletterCombinationsOfAPhoneNumber  = new MyBacktrack_LetterCombinationsOfAPhoneNumber();
        myBacktrackletterCombinationsOfAPhoneNumber.letterCombinations("23").forEach(System.out::println);
    }
}
