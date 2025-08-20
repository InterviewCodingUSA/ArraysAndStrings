//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        System.out.println(largestSubarraySumLessThanK(arr, 8));
    }

    // Returns the largest subarray sum that is less than k using a sliding window approach
    private static int largestSubarraySumLessThanK(int[] arr, int k) {
        // Check for null or empty array, return 0 if true
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Initialize maximum sum found
        int maxSum = 0;
        // Initialize current sum of the sliding window
        int currSum = 0;
        // Initialize start pointer of the sliding window
        int start = 0;

        // Iterate through the array with end pointer
        for (int end = 0; end < arr.length; end++) {
            // Add current element to window sum
            currSum += arr[end];

            // Shrink window from start while sum is >= k
            while (currSum >= k && start <= end) {
                // Remove start element from sum and move start pointer
                currSum -= arr[start];
                start++;
            }

            // Update maxSum if current sum is larger
            maxSum = Math.max(maxSum, currSum);
        }

        // Return the largest sum found that's less than k
        return maxSum;
    }
}