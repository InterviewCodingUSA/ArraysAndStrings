import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {7,4,3,9,1,8,5,2,6};
        long[] averages = getAveragesArraySizeK(arr,3);
        for(long i : averages){
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static long[] getAveragesArraySizeK(int[] arr, int k){
        if(k <= 0 ||  2 * k + 1 > arr.length){
            return null;
        }
        int windowSize = 2 * k + 1;
        long[] averages = new long[arr.length];
        Arrays.fill(averages, -1);

        long[] prefix = new long[arr.length + 1];
        for (int i = 0; i < arr.length; ++i) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        // We iterate only on those indices which have atleast 'k' elements in their left and right.
        // i.e. indices from 'k' to 'n - k'
        for (int i = k; i < (arr.length - k); ++i) {
            int leftBound = i - k, rightBound = i + k;
            long subArraySum = prefix[rightBound + 1] - prefix[leftBound];
            int average = (int) (subArraySum / windowSize);
            averages[i] = average;
        }

        return averages;

    }
}