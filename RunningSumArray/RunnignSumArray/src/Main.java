//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] runningSum = runningSumArray(arr);
        for(int i : runningSum){
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static int[] runningSumArray(int[] arr){
        int[] result = new int[arr.length];

        // Initialize first element of result array with first element in nums.
        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            result[i] = result[i - 1] + arr[i];
        }
        return result;
    }
}