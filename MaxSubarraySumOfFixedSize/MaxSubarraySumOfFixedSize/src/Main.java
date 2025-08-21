//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {3,-1,4,12, -8, 5,6};
        System.out.println(maxSubArraySumOfFixedSize(arr, 4));
    }

    public static int maxSubArraySumOfFixedSize(int[] arr, int k){
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += arr[i];
        }

        int ans = curr;
        for (int i = k; i < arr.length; i++) {
            curr += arr[i] - arr[i - k];
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}