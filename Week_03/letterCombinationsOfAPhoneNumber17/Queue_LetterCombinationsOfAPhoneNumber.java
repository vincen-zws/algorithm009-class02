package letterCombinationsOfAPhoneNumber17;
import java.util.LinkedList;
import java.util.List;


public class Queue_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() <= 0 ) return result;
        String[] map = new String[]{"0", "1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        while(result.peek().length() != digits.length()) {
            String remove = result.removeFirst();
            String letters = map[digits.charAt(remove.length()) - '0'];
            for (char c : letters.toCharArray()) {
                result.add(remove + c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Queue_LetterCombinationsOfAPhoneNumber queue_letterCombinationsOfAPhoneNumber = new Queue_LetterCombinationsOfAPhoneNumber();
        queue_letterCombinationsOfAPhoneNumber.letterCombinations("23").forEach(System.out::println);
    }
}
