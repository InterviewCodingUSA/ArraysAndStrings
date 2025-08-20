//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Problem becomes longest Substring with atmost 1 zero.

        System.out.println(flipOneZeroToGetMaxOnes("1101100111"));

    }

    private static int flipOneZeroToGetMaxOnes(String str){
        int maxLength = 0;
        int left = 0;
        int zeros = 0;

        // Sliding window approach
        for (int right = 0; right < str.length(); right++) {
            // Count zeros in current window
            if (str.charAt(right) == '0') {
                zeros++;
            }

            // If we have more than one zero, shrink window
            while (zeros > 1) {
                if (str.charAt(left) == '0') {
                    zeros--;
                }
                left++;
            }

            // Update maxLength if current window is larger
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}