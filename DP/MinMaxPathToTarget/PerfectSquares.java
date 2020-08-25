package DP.MinMaxPathToTarget;
import java.util.Arrays;

// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
public class PerfectSquares {
    static int[] arr;
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        int[] squares = new int[n+1];
        for(int i =1; i<=n; i++) {
            squares[i] = i*i;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int maxSquareIndex = (int) Math.sqrt(n)+1;
        // apply pattern directly
        for(int i=1; i<=n; i++) {
            for(int j=1; j<maxSquareIndex; j++) {
                if(squares[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-squares[j]] + 1);
                }
            }
        }
        return dp[n];
    }
}
