import java.util.LinkedList;
import java.util.Queue;

/**
 * 4. Median of Two Sorted Arrays
 * 
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 */
class No004 {

    public void run() {
        // Input
        int[] nums1 = { 6 };
        int[] nums2 = { 3, 4 };

        // Solution
        double result = findMedianSortedArrays(nums1, nums2);

        // Output
        System.out.println(result);
    }

    /**
     * Solution 1
     */
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        Queue<Integer> queue = new LinkedList<>();

        int i = 0, j = 0;
        while (true) {
            if (i >= nums1.length) {
                addQueue(queue, nums2[j]);
                j++;
            } else if (j >= nums2.length) {
                addQueue(queue, nums1[i]);
                i++;
            } else if (nums1[i] < nums2[j]) {
                addQueue(queue, nums1[i]);
                i++;
            } else {
                addQueue(queue, nums2[j]);
                j++;
            }

            if (i + j - 1 == totalLen / 2) {
                break;
            }
        }

        if (totalLen % 2 == 0) {
            return 0.5 * (queue.remove() + queue.remove());
        } else {
            if (queue.size() > 1) {
                queue.remove();
            }
            return queue.remove();
        }
    }

    void addQueue(Queue<Integer> queue, int num) {
        if (queue.size() == 2) {
            queue.remove();
        }
        queue.add(num);
    }

}