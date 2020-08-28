package DP.MinMaxPathToTarget;
import java.util.*;

// Problem statement at the bottom
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

// In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
//
//Train tickets are sold in 3 different ways:
//
//    a 1-day pass is sold for costs[0] dollars;
//    a 7-day pass is sold for costs[1] dollars;
//    a 30-day pass is sold for costs[2] dollars.
//
//The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
//
//Return the minimum number of dollars you need to travel every day in the given list of days.