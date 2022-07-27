import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * If n = 5 -->
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */

/**
 * Regex -> (.)\1*
 * () -> Group
 * . -> 1 character
 * (.) -> Grouping 1 char
 * \ -> Matches the value in the group
 * 1 -> Most recent group
 * \1 -> The backreference \1 (backslash one) references the first capturing group. \1 matches the exact same text that was matched by the first capturing group.
 * * => any number of Char
 */
public class CountAndSay {

    public static void main(String[] args) {
        // input
        int n = 5;
        String regex = "(.)\\1*"; // second backslash is the matcher; 1st one is the escape sequence

        // start with 1
        String charSeq = "1";

        Pattern pattern = Pattern.compile(regex);

        // i=1 cuz 0th seq is predefined as 1(charSeq);
        for(int  i=1; i<n; i++){
            Matcher m = pattern.matcher(charSeq);
            StringBuilder sb = new StringBuilder();

            while(m.find()){
                sb.append(String.valueOf(m.group().length()) + m.group().charAt(0));
            }
            charSeq = sb.toString();
        }
        System.out.println(charSeq);
    }

}

// TC: O(2^n); SC: O(2 ^ n-1)