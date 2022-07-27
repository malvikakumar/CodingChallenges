// Find the number of times the words of String a occur in String b (string a abd b are sentences)

import java.util.*;

public class FrequencyOfWords {
    public static void main(String[] args) {
        String a = "my name is tejus";
        String b = "my name is tejus and i like tejus";

        String[] s1 = a.split(" ");
        String[] s2 = b.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for(String s: s1) {
            map.put(s, 0);
        }

        for(String s: s2) {
            if(map.get(s) != null) {
                map.put(s, map.get(s)+1);
            }
        }

        map.forEach((key,value) -> System.out.println(key+","+value));
    }
}