/**
 * 322. Coin Change
 * 
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 */
public class No322 {

    public void run() {
        // Input
        int[] coins = new int[] { 1 };
        int amount = 2;

        // Solution
        int result = coinChange(coins, amount);

        // Output
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int temp = i - coins[j];
                if (temp >= 0 && dp[temp] > -1) {
                    if (dp[i] > -1) {
                        dp[i] = Math.min(dp[temp] + 1, dp[i]);
                    } else {
                        dp[i] = dp[temp] + 1;
                    }
                }
            }
        }

        return dp[amount];
    }

}