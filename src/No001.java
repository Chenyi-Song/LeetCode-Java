/**
 * 1. Two Sum
 * 
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 */
class No001 {

    public void run() {
        // Input
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        // Solution
        int[] result = twoSum(nums, target);

        // Output
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    /**
     * Solution 1
     */
    private int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }
}