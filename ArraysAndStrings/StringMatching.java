// Given an array of string words. Return all strings in words which is substring of another word in any order.
import java.util.*;
public class StringMatching {
    public static void main(String[] args) {
        String[] words = {"mass","as","hero","superhero"};
        stringMatching(words).forEach(word -> System.out.println(word));
    }
    public static List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(words));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            String str = words[i];
            int start = i + 1;
            while (start < words.length) {
                if (words[start].contains(str)) {
                    result.add(str);
                    break;
                }
                start++;
            }
        }
        return result;
    }
}
