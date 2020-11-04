package ArraysAndStrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Compress string abbbcccdd to a1b3c3d2
public class StringCompression {
    public static void main(String[] args) {
        String str = "abbbcccdd";
        StringCompression sc = new StringCompression();
        System.out.println(sc.compress(str));
        System.out.println(sc.compressByPatternMatching(str));
    }

    public String compress(String str) {
        int count = 1;
        String compressedString = "";
        for(int i=0; i< str.length(); i++) {
            if(i+1 == str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedString = compressedString + str.charAt(i) + count;
                count = 1;
            } else {
                count++;
            }
        }
        return compressedString;
    }

    public String compressByPatternMatching(String str) {
        StringBuilder sb = new StringBuilder();
        String regex = "(.)\\1*";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        while(m.find()) {
            sb.append(m.group().charAt(0) + String.valueOf(m.group().length()));
        }
        return sb.toString();
    }
}