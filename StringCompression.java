// Compress string abbbcccdd to a1b3c3d2
public class StringCompression {
    public static void main(String[] args) {
        String str = "abbbcccdd";
        StringCompression sc = new StringCompression();
        System.out.println(sc.compress(str));
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
}