/**
 * 746. Min Cost Climbing Stairs
 * 
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 */
public class No746 {

    public void run() {
        // Input
        int[] cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

        // Solution
        int result = minCostClimbingStairs(cost);

        // Output
        System.out.println(result);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[dp.length - 1];
    }
}