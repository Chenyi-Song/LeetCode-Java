/**
 * 11. Container With Most Water
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
 * the x-axis forms a container, such that the container contains the most
 * water.
 */
class No011 {
    public void run() {
        // Input
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        // Solution
        // int result = maxArea1(height);
        int result = maxArea2(height);

        // Output
        System.out.println(result);
    }

    /**
     * Solution 1 
     * O(n^2)
     */
    public int maxArea1(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return area;
    }

    /**
     * Solution 1 
     * O(n)
     */
    public int maxArea2(int[] height) {
        int start = 0, end = height.length - 1;

        int area = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
            area = Math.max(area, (end - start) * Math.min(height[start], height[end]));
        }

        return area;
    }

}