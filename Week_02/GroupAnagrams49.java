import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //myself
//        return _func1SortedKey(strs);
        //solution
//        return _func2SortedKey(strs);
//        return _func3CodingKey(strs);
//        return _func4PrimeKeyIndex(strs);
        return _func4PrimeKeyHashMap(strs);
    }

    private List<List<String>> _func4PrimeKeyHashMap(String[] strs) {
        int[] primeNum = new int[]{2,3,5,7,11,13,17,19,23,29, 31,37,41,43,47,53,59,61,67,71, 73,79,83 ,89,97,101};
        HashMap<Integer,LinkedList<String>> map = new HashMap<>();
        for ( String s : strs) {
            int code = 1;
            for (char c : s.toCharArray()) {
                code *= primeNum[c - 'a'];
            }
            if ( !map.containsKey(code)) {
               map.put(code,new LinkedList<>());
            }
            map.get(code).add(s);
        }
        List<List<String>> result =  new LinkedList<>();
        for (LinkedList list : map.values()) {
            result.add(list) ;
        }
        return result;
    }

    private List<List<String>> _func4PrimeKeyIndex(String[] strs) {
        int[] primeNum = new int[]{2,3,5,7,11,13,17,19,23,29, 31,37,41,43,47,53,59,61,67,71, 73,79,83 ,89,97,101};
        HashMap<Integer , Integer> map = new HashMap<>();
        List<List<String>> result = new LinkedList();
        int resultIndex = 0;
        for (String s : strs) {
            int code = 1;
            for (char c : s.toCharArray()) {
                code *= primeNum[c - 'a'];
            }

            if (!map.containsKey(code)) {
                map.put(code,resultIndex++);
                result.add(new LinkedList<>());
            }
            result.get(map.get(code)).add(s);
        }
        return result;
    }

    private List<List<String>> _func3CodingKey(String[] strs) {
        HashMap<String , Integer> map =  new HashMap<>();
        List<List<String>> result = new LinkedList<>();
        int resutlIndex = 0;
        for (String s : strs) {
            char[] code = new char[26];
            for (char c : s.toCharArray()) {
                code[c - 'a'] += 1;
            }
            String codingString = Arrays.toString(code);
            if (!map.containsKey(codingString)) {
                result.add(new LinkedList<>());
                map.put(codingString,resutlIndex++);
            }
            result.get(map.get(codingString)).add(s);
        }
        return result;
    }

    private List<List<String>> _func2SortedKey(String[] strs) {
        HashMap<String , Integer> map = new HashMap<>();
        List<List<String>> result = new LinkedList<>();
        int resultIndex = 0 ;
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = Arrays.toString(chars);
            if (!map.containsKey(sortedString) ) {
                result.add(new LinkedList<>());
                map.put(sortedString,resultIndex++);
            }
                result.get(map.get(sortedString)).add(s);
        }
        return result;
    }

    private List<List<String>> _func1SortedKey(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = Arrays.toString(chars);
            if(!map.containsKey(sortedString)) {
                map.put(sortedString , new LinkedList<>());
            }
            map.get(sortedString).add(s);
        }
        List<List<String>> result = new LinkedList<>();
        for (List<String> sList: map.values()) {
            result.add(sList);
        }
        return result;
    }
}
