// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1) {
            return "";
        }
        
        String max = "";
        for(int i=0; i<s.length(); i++) {
            String s1 = expandAroundCenter(s, i, i);
            String s2 = expandAroundCenter(s, i , i+1);
            if(s1.length() > max.length()) max = s1;
            if(s2.length() > max.length()) max = s2;
        }
        return max;
    }
    
    public static String expandAroundCenter(String s, int begin, int end) {
        while(begin >=0 && end < s.length() && s.charAt(begin)==s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin+1, end);
    }

}

// TC: O(n^2), SC: O(1)