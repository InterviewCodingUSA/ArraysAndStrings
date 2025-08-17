import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Example 1: Array with a valid two sum solution
        int[] arr1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Example 1 (Sorting): " + twoSumWithSorting(arr1.clone(), target1)); // Expected: true
        int[] result1 = twoSumWithHashMapOnePass(arr1, target1);
        System.out.println("Example 1 (HashMap One Pass): [" + result1[0] + ", " + result1[1] + "]"); // Expected: [0, 1]

        // Example 2: Array with no two sum solution
        int[] arr2 = {1, 2, 3, 4};
        int target2 = 10;
        System.out.println("Example 2 (Sorting): " + twoSumWithSorting(arr2.clone(), target2)); // Expected: false
        int[] result2 = twoSumWithHashMapOnePass(arr2, target2);
        System.out.println("Example 2 (HashMap One Pass): " + (result2.length == 0 ? "[]" : "[" + result2[0] + ", " + result2[1] + "]")); // Expected: []

        // Example 3: Array with duplicate elements
        int[] arr3 = {3, 3, 4, 5};
        int target3 = 6;
        System.out.println("Example 3 (Sorting): " + twoSumWithSorting(arr3.clone(), target3)); // Expected: true
        int[] result3 = twoSumWithHashMapTwoPass(arr3, target3);
        System.out.println("Example 3 (HashMap Two Pass): [" + result3[0] + ", " + result3[1] + "]"); // Expected: [0, 1]
    }

    /**
     * Checks if there exists a pair of numbers in the array that sum to the target.
     * Uses sorting and two-pointer technique.
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(1) as it modifies the input array in-place (excluding input).
     * @param arr Input array of integers
     * @param target Target sum to find
     * @return true if a pair sums to target, false otherwise
     */
    private static boolean twoSumWithSorting(int[] arr, int target) {
        // Check if array has less than 2 elements
        if (arr.length <= 1) {
            return false;
        }
        // Sort the array to enable two-pointer technique
        Arrays.sort(arr);
        // Initialize two pointers: start at beginning, end at last element
        int start = 0;
        int end = arr.length - 1;
        // Iterate until pointers meet
        while (start < end) {
            // Calculate current sum
            int currentSum = arr[start] + arr[end];
            // If sum equals target, solution found
            if (currentSum == target) {
                return true;
                // If sum is less than target, increment start to increase sum
            } else if (currentSum < target) {
                start++;
                // If sum is more than target, decrement end to decrease sum
            } else {
                end--;
            }
        }
        // No solution found
        return false;
    }

    /**
     * Finds indices of two numbers that sum to the target using a two-pass HashMap.
     * Time Complexity: O(n) for two passes through the array.
     * Space Complexity: O(n) for storing elements in the HashMap.
     * @param arr Input array of integers
     * @param target Target sum to find
     * @return Array of indices of the two numbers, or empty array if no solution
     */
    private static int[] twoSumWithHashMapTwoPass(int[] arr, int target) {
        // Initialize HashMap to store number-to-index mappings
        HashMap<Integer, Integer> map = new HashMap<>();
        // First pass: store all numbers and their indices
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        // Second pass: check for complement of each number
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // If complement exists and is not the same index, return indices
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // No solution found, return empty array
        return new int[] {};
    }

    /**
     * Finds indices of two numbers that sum to the target using a one-pass HashMap.
     * Time Complexity: O(n) for a single pass through the array.
     * Space Complexity: O(n) for storing elements in the HashMap.
     * @param arr Input array of integers
     * @param target Target sum to find
     * @return Array of indices of the two numbers, or empty array if no solution
     */
    private static int[] twoSumWithHashMapOnePass(int[] arr, int target) {
        // Initialize HashMap to store number-to-index mappings
        Map<Integer, Integer> map = new HashMap<>();
        // Single pass: check for complement and store current number
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // If complement exists, return its index and current index
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // Store current number and its index
            map.put(arr[i], i);
        }
        // No solution found, return empty array
        return new int[] {};
    }
}