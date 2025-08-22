//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {10,5,2,6};
        System.out.println(numSubArraysProductLessThanK(arr, 100));
    }

    private static int numSubArraysProductLessThanK(int[] arr, int k){
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < arr.length; right++) {
            curr *= arr[right];
            while (curr >= k) {
                curr /= arr[left];
                left++; // A
            }

            ans += right - left + 1;
        }

        return ans;
    }
}