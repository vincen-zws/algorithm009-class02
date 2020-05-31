import java.util.Arrays;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
//      return _func1SortAndCompare(s,t);
//        return _func2CodingAndCompare(s,t);
        return _func3HashMapTwice(s,t);

//        return
    }

    private boolean _func3HashMapTwice(String s, String t) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length() ; i++) {
            charCount[s.charAt(i) - 'a'] += 1;
            charCount[t.charAt(i) - 'a'] -= 1;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
     }

    private boolean _func2CodingAndCompare(String s, String t) {
        int[] sCharCount = new int[26];
        int[] tCharCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int sIndex = s.charAt(i) - 'a';
            int tIndex = t.charAt(i) - 'a';
            sCharCount[sIndex] += 1;
            tCharCount[tIndex] += 1;
        }

        for (int i = 0; i < sCharCount.length; i++) {
            if (sCharCount[i] != tCharCount[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean _func1SortAndCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }
}
