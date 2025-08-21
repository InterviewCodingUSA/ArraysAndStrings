//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        System.out.println(maxAverageSubArray(arr, 4));
    }

    private static float maxAverageSubArray(int[] arr, int k){
        int currentSum = 0;
        for(int i = 0 ; i < k ; i ++){
          currentSum += arr[i];
        }
        float currentAverage  = (float)currentSum/k;
        float maxAverage = currentAverage;
        for(int i = k ; i < arr.length; i ++){
            currentSum -= arr[i-k];
            currentSum += arr[i];
            currentAverage = (float)currentSum/k;
            maxAverage = Math.max(currentAverage, maxAverage);
        }
        return maxAverage;
    }
}