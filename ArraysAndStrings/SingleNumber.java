package ArraysAndStrings;
// Given a non-empty array of integers, every element appears twice except for one. Find that single one.

import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        int[] arr = {1, 3, 5, 5, 1};
        System.out.println(s.singleNumber(arr));
    }
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i : nums) {
            if(map.get(i) == 1) return i;
        }
        return 0;
    }
}

// Alternate - put in set; while adding if (!set.add(..)) then that's appearing twice, so return it