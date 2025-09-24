import java.util.HashMap;
import java.util.Map;

public class Prefix {
    public int subarraySum(int[] nums, int k) {
        // int count = 0;
        // for (int start = 0; start < nums.length; start++) {
        // int sum = 0;
        // for (int end = start; end < nums.length; end++) {
        // sum += nums[end];
        // if (sum == k) count++;
        // }
        // }
        // return count;

        int count = 0, sum = 0;
        // Map<Integer (cumulativeSum), Integer (frequency)>
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); // base case: sum = 0 occurs once

        for (int num : nums) {
            sum += num;

            // Check if (sum - k) has been seen before
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }

            // Update the frequency of current sum in the map
            if (prefixSum.containsKey(sum)) {
                prefixSum.put(sum, prefixSum.get(sum) + 1);
            } else {
                prefixSum.put(sum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Prefix solution = new Prefix();

        // Example 1
        int[] nums1 = { 1, 2, 3 };
        int k1 = 3;
        int result1 = solution.subarraySum(nums1, k1);
        System.out.println("Example 1 Result: " + result1); // Expected: 2 ([1,2] and [3])

        int[] nums4 = { 1, -1, 0 };
        int k4 = 0;
        int result4 = solution.subarraySum(nums4, k4);
        System.out.println("Example 1 Result: " + result4); // Expected: 2 ([1,2] and [3])

        // Example 2
        int[] nums2 = { 1, 1, 1 };
        int k2 = 2;
        int result2 = solution.subarraySum(nums2, k2);
        System.out.println("Example 2 Result: " + result2); // Expected: 2 ([1,1] at index 0-1 and 1-2)

        // Example 2
        int[] nums3 = { 1, 1, 0, 1 };
        int k3 = 2;
        int result3 = solution.subarraySum(nums3, k3);
        System.out.println("Example 2 Result: " + result3); // Expected: 3
    }
}
