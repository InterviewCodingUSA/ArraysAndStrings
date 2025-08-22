//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {-3,2,-3,4,2};
        System.out.println(minValueToGetPositive(arr));
    }

    private static int minValueToGetPositive(int[] arr){
        int minVal = 0;
        int total = 0;

        // Iterate over the array and get the minimum step-by-step total.
        for (int num : arr) {

            total += num;
            minVal = Math.min(minVal, total);
        }

        // We have to let the minimum step-by-step total equals to 1,
        // by increasing the startValue from 0 to -minVal + 1,
        // which is just the minimum startValue we want.
        return -minVal + 1;
    }
}