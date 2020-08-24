package DP.MinMaxPathToTarget;
import java.util.*;

public class MinCostForTickets {
    static Integer[] memo;
    static Set<Integer> dayset;
    static int[] costs;
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int costs[] = {2,7,15};
        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] cost) {
        memo = new Integer[366];
        dayset = new HashSet<Integer>();
        costs = cost;
        for(int d: days) dayset.add(d);

        return dp(1);
    }

    public static int dp(int i) {
        if(i > 365) return 0;
        if(memo[i] != null) return memo[i];

        int ans;
        if(dayset.contains(i)) {
            // dp(i)=min(dp(i+1)+costs[0],dp(i+7)+costs[1],dp(i+30)+costs[2])
            ans = Math.min(dp(i+1)+costs[0], dp(i+7)+costs[1]);
            ans = Math.min(ans, dp(i+30)+costs[2]);
        } else {
            ans = dp(i+1);
        }
        memo[i] = ans;
        return ans;
    }
}
