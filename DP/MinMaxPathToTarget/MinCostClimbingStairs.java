package DP.MinMaxPathToTarget;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs(new int[]{0, 0, 1, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length-1;
        for(int i=2; i<=len; i++) {
            cost[i] = Math.min(cost[i-1],cost[i-2]) + cost[i];
        }
        return Math.min(cost[len],cost[len-1]);
    }
}
