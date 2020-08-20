package ArraysAndStrings;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(stringToInt("42"));
        System.out.println(stringToInt("  -42"));
        System.out.println(stringToInt("+1"));
        System.out.println(stringToInt("4193 with words"));
        System.out.println(stringToInt("words and 987"));
        System.out.println(stringToInt("-91283472332"));

    }
    public static int stringToInt(String str) {
        String s = str.trim();
        int result = 0;
        boolean isNegative = false;
        if(s.isEmpty()) {
            // !Character.isDigit(s.charAt(0)) ||
            // !s.charAt(0)=='-') {
            return 0;
        }
        int i=0;
        if(s.charAt(0) == '-') {
            isNegative = true;
            i = 1;
        } else if (s.charAt(0) == '+') {
            i = 1;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))) {
            if(result>Integer.MAX_VALUE/10 ||
                    (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            int num = s.charAt(i)-'0';
            result = result*10 + num;

            i++;
        }
        return isNegative ? 0-result : result;
    }
}
