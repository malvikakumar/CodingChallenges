// URLify - Replace spl chars with %20

public class CharReplace {
    public static void main(String[] args) {
        String str = "Mr.John Smith  @ ";

        str = str.trim();
        System.out.println(str);

        // str = str.replaceAll("\\W", "%20");
        str = str.replaceAll("[^a-zA-Z]+", "%20");
        System.out.println(str);
    }
}
/**
 * \w : A word character, short for [a-zA-Z_0-9] \W : A non-word character
 */