// Given an array of strings, group anagrams together.
import java.util.*;
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagrams = groupAnagrams(stringArray);
        System.out.println((anagrams));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<String>());
            ans.get(key).add(s);
        }

        return new ArrayList<List<String>>(ans.values());
    }
}