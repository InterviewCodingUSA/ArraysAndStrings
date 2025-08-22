import java.util.Enumeration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {10,4,-8,7};
        System.out.println(numWaysToSplitArray(arr));
    }

    public static int numWaysToSplitArray(int[] arr){

        // Prefix sum array to store cumulative sums
        int[] prefSum = new int[arr.length];
        prefSum[0] = arr[0];

        // Build prefix sum array
        for (int i = 1; i < arr.length; i++) {
            prefSum[i] = prefSum[i - 1] + arr[i];
        }

        int count = 0;
        // Check each possible split position
        for (int i = 0; i < arr.length - 1; i++) {
            // Sum of left part (0 to i)
            long leftSum = prefSum[i];
            // Sum of right part (i+1 to n-1)
            long rightSum = prefSum[arr.length - 1] - prefSum[i];

            if (leftSum >= rightSum) {
                count++;
            }
        }

        return count;
    }
}