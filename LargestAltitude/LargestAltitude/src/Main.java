//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {-5,1,5,0,-7};
        System.out.println(largestAltitude(arr));
    }

    private static int largestAltitude(int[] arr){
        int currentAltitude = 0;
        // Highest altitude currently is 0.
        int highestPoint = currentAltitude;

        for (int altitudeGain : arr) {
            // Adding the gain in altitude to the current altitude.
            currentAltitude += altitudeGain;
            // Update the highest altitude.
            highestPoint = Math.max(highestPoint, currentAltitude);
        }

        return highestPoint;
    }
}