import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        int res1 = lengthOfLongestSubstring("abcabcbb");
        System.out.println(res1);
        int res2 = lengthOfLongestSubstring("bbbbbb");
        System.out.println(res2);
        int res3 = lengthOfLongestSubstring("pwwkew");
        System.out.println(res3);
        int res4 = lengthOfLongestSubstring2("pwwkew");
        System.out.println(res4);
    }

    // Approach 1 - has sliding window template and more efficient
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int maxLength = 0, windowStart = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char endChar = s.charAt(windowEnd);
            if (m.containsKey(endChar)) {
                // If it does, then set windowStart to either current windowStart or the index of the windowEnd char in the map
                windowStart = m.get(endChar);

            } else {
                // Put the windowEnd char into map with value as the index of endChar
                m.put(endChar, windowEnd+1);
                // Set maxLength to either current maxLength or the length b/w windowEnd and windowStart
                maxLength = Math.max(maxLength, (windowEnd-windowStart+1));
            }
        }
        return maxLength;
    }

    // Approach 2
    public static int lengthOfLongestSubstring2(String s) {
        int finalStart = 0, finalEnd = 0;
        int start = 0, end = 0;
        HashSet<Character> set = new HashSet<>();

        while (end < s.length() - 1) {
            int current = end + 1;
            if (!set.add(s.charAt(current))) {
                if (finalEnd - finalStart < end - start) {
                    finalEnd = end;
                    finalStart = start;
                }
                start++;
                end = start;
                set.clear();
            } else {
                end = current;
            }
        }
        return finalEnd - finalStart;
    }
}
