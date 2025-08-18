//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Example usage of squareOfSortedArrays
        int[] input = {-4,-1,0,3,10}; // Example sorted array (ascending order)
        int[] result = squareOfSortedArrays(input);

        // Print the result
        System.out.print("Input array: ");
        for (int num : input) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Squared array: ");
        if (result != null) {
            for (int num : result) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Result is null");
        }
    }

    /**
     * Takes a sorted array and returns a new array containing squares of the input elements
     * in ascending order. The input array is assumed to be sorted in ascending order.
     * @param arr The input sorted array
     * @return An array containing squares of input elements in ascending order, or null if input is empty
     */
    public static int[] squareOfSortedArrays(int[] arr) {
        // Check if input array is empty
        if (arr.length == 0) {
            return null;
        }

        // Create new array to store squared values
        int[] square = new int[arr.length];

        // Index to track position in result array
        int index = square.length-1;
        // Pointer to start of input array
        int start = 0;
        // Pointer to end of input array
        int end = arr.length - 1;

        // Process until all elements are squared
        while (index > 0 ) {
            int val =0;
            if (Math.abs(arr[start]) < Math.abs(arr[end])) {
                val = arr[end];
                end--;
            } else {
                val = arr[start];
                start++;
            }
            square[index--] = val * val;
        }
        return square;
    }
}