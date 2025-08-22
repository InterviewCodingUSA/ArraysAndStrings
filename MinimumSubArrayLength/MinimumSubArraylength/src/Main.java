//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLength(arr, 7));
    }
    private static int minSubArrayLength(int[] arr, int target){
        int left = 0, right = 0, sumOfCurrentWindow = 0;
        int res = Integer.MAX_VALUE;

        for(right = 0; right < arr.length; right++) {
            sumOfCurrentWindow += arr[right];

            while (sumOfCurrentWindow >= target) {
                res = Math.min(res, right - left + 1);
                sumOfCurrentWindow -= arr[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}