//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
import java.util.*;
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(var entry: map.entrySet()) {
            if(entry.getValue() > nums.length/2) return entry.getKey();
        }
        return 0;

        // Different method - had faster runtime in leetcode but overall time complexity is higher (because for larger sets O(n logn) takes longer than O(n))
        // Arrays.sort(nums);
        // return (nums[nums.length/2]);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,1,1,1,2,2};
        int max = majorityElement(nums);
        System.out.println(max);
    }
}
