//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));
    }

    private static int pivotIndex(int[] arr){
        int sum = 0, leftsum = 0;
        for (int x: arr) sum += x;
        for (int i = 0; i < arr.length; ++i) {
            if (leftsum == sum - leftsum - arr[i]) {
                return i;
            }

            leftsum += arr[i];
        }
        return -1;
    }
}