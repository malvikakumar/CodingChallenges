import java.util.*;

// Given a string, determine if a permutation of the string could form a palindrome.
public class PermutationPalindrome {
    public static void main(String[] args) {
        PermutationPalindrome p = new PermutationPalindrome();
        System.out.println(p.canPermutePalindrome("code"));
        System.out.println(p.canPermutePalindrome("aab"));
        System.out.println(p.canPermutePalindrome("carerac"));
        System.out.println(p.canPermutePalindrome("abac"));
    }

    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if(!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
        }
        
        return (set.size() <= 1);
    }
}