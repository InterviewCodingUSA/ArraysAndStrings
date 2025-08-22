//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String str = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(str));
    }

    private static String reverseOnlyLetters(String str){
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length -1;

        while(start < end){
            while( !Character.isLetter( arr[start] ) ){
                start ++;
            }
            while( !Character.isLetter( arr[end] ) ){
                end --;
            }
            if(start >= end){
                break;
            }
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }

        return new String(arr);
    }
}