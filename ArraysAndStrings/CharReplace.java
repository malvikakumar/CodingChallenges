// URLify - Replace space with %20

public class CharReplace {
    public static void main(String[] args) {
        String str = "Mr John Smith   ";

        str = str.trim();
        System.out.println(str);

        str = str.replaceAll(" ", "%20");
        System.out.println(str);        
    }
}