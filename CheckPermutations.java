import java.util.*;

public class CheckPermutations {
    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "aabb";

        CheckPermutations c = new CheckPermutations();
        System.out.println("Bruteforce answer: "+c.bruteForceCheck(s1,s2));
        System.out.println("Optimized answer: "+c.optimizedCheck(s1,s2));
    
    }

    // Time Complexity: O(n log n)
    public boolean bruteForceCheck(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0; i<ch1.length; i++) {
            if(ch1[i] != ch2[i]) return false;
        }
        return true;
    }

    // Time Complexity: O(n)
    public boolean optimizedCheck(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        // Create count arrays of size 256 for both strings. Initialize all values in count arrays as 0.
        int countArray[] = new int[256];

        // Iterate through every character of both strings and increment the count if it's in s1, decrement for s2
        for(int i=0; i<s1.length(); i++) {
            countArray[s1.charAt(i)]++;
            countArray[s2.charAt(i)]--;
        }

        // If all are 0, then it's a permutation
        for(int i=0; i<countArray.length; i++) {
            if(countArray[i] != 0) return false;
        }

        return true;
    }
}