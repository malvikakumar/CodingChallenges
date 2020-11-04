package ArraysAndStrings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(s));
        System.out.println(isValidPalindrome("race a car"));
    }

    public static boolean isValidPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while (start < end) {
            char c1 = s.charAt((start));
            char c2 = s.charAt((end));
            if (!Character.isLetterOrDigit(c1)) {
                start++;
            } else if (!Character.isLetterOrDigit(c2)) {
                end--;
            } else if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
