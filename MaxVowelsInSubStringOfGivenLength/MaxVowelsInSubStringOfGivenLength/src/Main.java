import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String str = "abciiidef";
        System.out.println(maxVowelsInSubStringOfGivenLength(str, 3));
    }

    private static int maxVowelsInSubStringOfGivenLength(String str, int k){
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // Build the window of size k, count the number of vowels it contains.
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += vowels.contains(str.charAt(i)) ? 1 : 0;
        }
        int answer = count;

        // Slide the window to the right, focus on the added character and the
        // removed character and update "count". Record the largest "count".
        for (int i = k; i < str.length(); i++) {
            count += vowels.contains(str.charAt(i)) ? 1 : 0;
            count -= vowels.contains(str.charAt(i - k)) ? 1 : 0;
            answer = Math.max(answer, count);
        }

        return answer;
    }
}