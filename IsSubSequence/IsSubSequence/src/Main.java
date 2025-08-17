//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Example usage of isSubSequence method
        String sequence = "abc";
        String target = "ahbgdc";
        boolean result = isSubSequence(sequence, target);
        System.out.println("Is '" + sequence + "' a subsequence of '" + target + "'? " + result);

        // Additional example
        sequence = "axc";
        target = "ahbgdc";
        result = isSubSequence(sequence, target);
        System.out.println("Is '" + sequence + "' a subsequence of '" + target + "'? " + result);
    }

    /**
     * Checks if str1 is a subsequence of str2.
     * A subsequence is a sequence that can be derived from another sequence by deleting
     * some or no elements without changing the order of the remaining elements.
     *
     * @param sequence The potential subsequence string
     * @param target The target string to check against
     * @return true if str1 is a subsequence of str2, false otherwise
     * Time Complexity: O(n) where n is the length of target string
     * Space Complexity: O(1) as we only use two pointers
     */
    private static boolean isSubSequence(String sequence, String target) {
        // If sequence is longer than target, it cannot be a subsequence
        if (sequence.length() > target.length()) {
            return false;
        }

        // Initialize pointers for sequence and target strings
        int seqIndex = 0;
        int targetIndex = 0;

        // Traverse target string
        while (targetIndex < target.length()) {
            // If characters match, move sequence pointer
            if (seqIndex < sequence.length() && sequence.charAt(seqIndex) == target.charAt(targetIndex)) {
                seqIndex++;
            }
            // Always move target pointer
            targetIndex++;
        }

        // Return true if all characters in sequence were found in order
        return seqIndex == sequence.length();
    }
}