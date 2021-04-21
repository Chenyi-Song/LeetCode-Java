import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 */
public class No015 {

    public void run() {
        List<List<Integer>> result = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });

        System.out.print("[");
        for (List<Integer> list : result) {
            System.out.print("[" + list.get(0) + "," + list.get(1) + "," + list.get(2) + "], ");
        }
        System.out.print("]");
        System.out.println();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1 && nums[i] + nums[j] <= 0; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int target = 0 - nums[i] - nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > target) {
                        break;
                    } else if (nums[k] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        break;
                    }
                }
            }
        }

        return result;
    }
}
