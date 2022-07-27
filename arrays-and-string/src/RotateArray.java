import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        // return nums;
    }
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] a = {1,2,3,4,5,6,7};
        r.rotate(a, 3);
        System.out.println("[1,2,3,4,5,6,7], 3 = "+ Arrays.toString(a));
        int[] b = {-1,-100,3,99};
        r.rotate(b, 2);
        System.out.println("{-1,-100,3,99}, 2 = "+ Arrays.toString(b));
        // Arrays.stream(r.rotate(b, 2)).forEach(System.out::print);
    }
}

// TC: O(n); SC: O(1)