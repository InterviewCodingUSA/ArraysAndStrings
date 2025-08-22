//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String str = "This is a simple string";
        System.out.println(reverseWordsOfString(str));
    }

    private static String reverseWordsOfString(String str) {
        char[] arr = str.toCharArray();
        if (arr.length <= 1) {
            return str;
        }
        int start = 0;
        int end = 0;
        while (start < arr.length) {
            if(end == arr.length -1){
                break;
            }
            // find first space
            while (arr[end] != ' ') {
                end++;
                if(end == arr.length){
                    break;
                }
            }
            reverseString(arr, start, end-1);
            start = end +1;
            end = start;
        }
        return new String(arr);
    }

    private static void reverseString(char[] arr, int start, int end){
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
