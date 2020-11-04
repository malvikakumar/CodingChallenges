package ArraysAndStrings;

public class ReverseInt {
    public static void main(String[] args) {
        int num = 123;
        int result = 0;
        while(num > 0) {
            int r = num%10;
            result = result * 10 + r;
            num /= 10;
        }
        System.out.println(result);
    }
}