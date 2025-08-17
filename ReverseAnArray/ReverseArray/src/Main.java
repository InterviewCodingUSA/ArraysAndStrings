//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create instance of Main class
        Main main = new Main();

        // Example 1: Basic string reversal
        char[] example1 = {'h', 'e', 'l', 'l', 'o'};
        System.out.print("Example 1 - Before: ");
        System.out.println(example1);
        main.reverseString(example1);
        System.out.print("Example 1 - After: ");
        System.out.println(example1);

        // Example 2: Single character
        char[] example2 = {'a'};
        System.out.print("Example 2 - Before: ");
        System.out.println(example2);
        main.reverseString(example2);
        System.out.print("Example 2 - After: ");
        System.out.println(example2);

        // Example 3: Empty array
        char[] example3 = {};
        System.out.print("Example 3 - Before: ");
        System.out.println(example3);
        main.reverseString(example3);
        System.out.print("Example 3 - After: ");
        System.out.println(example3);
    }

    // Reverses the characters in the input array in-place
    // Time Complexity: O(n) where n is the length of the input array
    // Space Complexity: O(1) as we only use a constant amount of extra space
    public void reverseString(char[] str) {
        // Handle empty or single-character arrays
        if (str.length <= 1) {
            return;
        }

        // Initialize pointers for start and end of array
        int left = 0;
        int right = str.length - 1;

        // Swap characters from both ends until pointers meet
        // This loop runs n/2 times, making it O(n)
        while (left < right) {
            // Swap characters at left and right pointers
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;

            // Move pointers towards center
            left++;
            right--;
        }
    }
}