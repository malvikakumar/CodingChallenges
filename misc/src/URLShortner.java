// TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl 
// and it returns a short URL such as http://tinyurl.com/4e9iAk.

// Design the encode and decode methods for the TinyURL service.

// See this problen in: https://leetcode.com/problems/encode-and-decode-tinyurl/solution/
import java.util.*;

public class URLShortner {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    public String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

    public static void main(String[] args) {
        URLShortner urlShortner = new URLShortner();
        String longUrl = "hellohi123";
        String shortUrl = urlShortner.encode(longUrl);
        System.out.println("Short url: "+shortUrl);
        System.out.println("Long url: "+urlShortner.decode(shortUrl));
    }
}
