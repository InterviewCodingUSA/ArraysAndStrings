//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Example 1: Merging two sorted arrays with recursive method
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] result1 = mergeSortedArraysRecursive(arr1, arr2);
        System.out.print("Recursive Merge Result: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 2: Merging two sorted arrays with iterative method
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {4, 5, 6};
        int[] result2 = mergeSortedArraysIterative(arr3, arr4);
        System.out.print("Iterative Merge Result: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 3: Merging arrays with different sizes
        int[] arr5 = {1, 5, 9};
        int[] arr6 = {2};
        int[] result3 = mergeSortedArraysRecursive(arr5, arr6);
        System.out.print("Recursive Merge Different Sizes: ");
        for (int num : result3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Time Complexity: O(n) where n is the total number of elements in arr1 and arr2
    // Space Complexity: O(n) for the recursion stack and output array
    private static int[] mergeSortedArraysRecursive(int[] arr1, int[] arr2) {
        // Handle null input cases
        if (arr1 == null) {
            return arr2;
        }
        if (arr2 == null) {
            return arr1;
        }
        int[] merged = new int[arr1.length + arr2.length];
        mergeSortedArrays(merged, arr1, arr2, 0, 0, 0);
        return merged;
    }

    // Helper method for recursive merge
    // Time Complexity: O(n) as each element is processed exactly once
    private static void mergeSortedArrays(int[] merged, int[] arr1, int[] arr2, int index, int index1, int index2) {
        // Base case: if merged array is fully filled
        if (index == merged.length) {
            return;
        }
        // If arr1 is exhausted, take from arr2
        if (index1 == arr1.length) {
            merged[index++] = arr2[index2++];
            mergeSortedArrays(merged, arr1, arr2, index, index1, index2);
            return;
        }
        // If arr2 is exhausted, take from arr1
        if (index2 == arr2.length) {
            merged[index++] = arr1[index1++]; // Fixed bug: was incorrectly using arr2[index1++]
            mergeSortedArrays(merged, arr1, arr2, index, index1, index2);
            return;
        }
        // Compare and take smaller element
        if (arr1[index1] <= arr2[index2]) {
            merged[index++] = arr1[index1++]; // Fixed bug: was incorrectly using arr2[index2++]
            mergeSortedArrays(merged, arr1, arr2, index, index1, index2);
        } else {
            merged[index++] = arr2[index2++];
            mergeSortedArrays(merged, arr1, arr2, index, index1, index2);
        }
    }

    // Time Complexity: O(n) where n is the total number of elements in arr1 and arr2
    // Space Complexity: O(n) for the output array only
    private static int[] mergeSortedArraysIterative(int[] arr1, int[] arr2) {
        // Handle null input cases
        if (arr1 == null) {
            return arr2;
        }
        if (arr2 == null) {
            return arr1;
        }
        int[] merged = new int[arr1.length + arr2.length];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        // Merge arrays while both have elements
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] <= arr2[index2]) {
                merged[index++] = arr1[index1++];
            } else {
                merged[index++] = arr2[index2++];
            }
        }
        // Copy remaining elements from arr1, if any
        while (index1 < arr1.length) {
            merged[index++] = arr1[index1++];
        }
        // Copy remaining elements from arr2, if any
        while (index2 < arr2.length) {
            merged[index++] = arr2[index2++];
        }
        return merged;
    }


}