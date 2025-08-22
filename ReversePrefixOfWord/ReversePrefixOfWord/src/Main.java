//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String str = "abcdefd";
        System.out.println(reversePrefixOfWord(str, 'd'));
    }

    private static String reversePrefixOfWord(String str, char ch){
        char[] arr = str.toCharArray();

        int start = 0;
        int end = 0;
        while(arr[end] != ch){
            end++;
            if(end >= arr.length){
                return str ;
            }
        }
        reverse(arr, start, end);

        return new String(arr);
    }

    private static void reverse(char[] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}