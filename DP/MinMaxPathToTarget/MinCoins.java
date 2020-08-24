package DP.MinMaxPathToTarget;
import java.util.*;

public class MinCoins {
    public static void main(String[] args) {
        System.out.println(minCoins(new int[]{1, 2, 5}, 11));
        System.out.println(minCoins(new int[]{2}, 3));
        System.out.println(minCoins(new int[]{186,419,83,408}, 6249));
        System.out.println(minCoins(new int[]{5,12}, 15));

    }

    public static int minCoins(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=1;i<=amount;i++) {
            for(int j=0; j<coins.length; j++) {
                if(coins[j]<=i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount]>amount ? -1 : dp[amount];

//        Arrays.sort(coins);
//        int count = 0;
//        int currentCoinAmount = 0;
//
//        for(int i=coins.length-1; i>=0; i--) {
//            int currentCoin = coins[i];
//            while(currentCoinAmount+currentCoin <= amount){
//                currentCoinAmount += currentCoin;
//                count++;
//            }
//            if(currentCoinAmount == amount) {
//                return count;
//            }
//        }
//        return -1;
    }
}
