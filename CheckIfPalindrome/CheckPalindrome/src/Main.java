//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String str = "1234321";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str){
        if(str.isEmpty() || str.length() == 1){
            return true;
        }
        int start = 0;
        int end = str.length()-1;
        while(start != end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}