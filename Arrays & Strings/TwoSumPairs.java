// Given an array of integers, return all indices of the two numbers that add up to a specific target.
import java.util.*;

public class TwoSumPairs {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 5, 4};
        ArrayList<ArrayList<Integer>> result = twoSum(arr, 9);
        result.forEach(System.out::println);
    }
    public static ArrayList<ArrayList<Integer>> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        for(int i=0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                ar.add(new ArrayList<>(Arrays.asList(map.get(complement), i)));
            }
            map.put(nums[i], i);
        }
        return ar;
    }
}