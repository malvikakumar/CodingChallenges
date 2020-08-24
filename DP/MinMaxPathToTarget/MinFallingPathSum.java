package DP.MinMaxPathToTarget;

// Given a square array of integers A, we want the minimum sum of a falling path through A.
//
//A falling path starts at any element in the first row, and chooses one element from each row.
// The next row's choice must be in a column that is different from the previous row's column by at most one.

public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingPathSum(arr));
    }

    public static int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int prev = j-1 >=0 ? A[i+1][j-1] : Integer.MAX_VALUE;
                int cur = A[i+1][j];
                int next = j+1 < n ?A[i+1][j+1] : Integer.MAX_VALUE;
                A[i][j] += getMinValue(new int[]{prev,cur,next});
            }
        }
        return getMinValue(A[0]);
    }
    public static int getMinValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            min = Math.min(nums[i],min);
        }
        return min;
    }
}
