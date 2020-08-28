package DP.MinMaxPathToTarget;

// On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
// Once you pay the cost, you can either climb one or two steps.
// You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
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
