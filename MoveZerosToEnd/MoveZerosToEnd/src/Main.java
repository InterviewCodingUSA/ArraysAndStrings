import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZerosToEndMaintainSequence(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZerosToEndMaintainSequence(int[] arr){

       int start = 0;
       int end = 1;
       while(end < arr.length){
           while(arr[start] != 0){
               start ++;
           }
           end = start +1;
           while(end < arr.length && arr[end] == 0 ){
               end ++;
               if(end >= arr.length)
                   break;
           }
           swap(arr, start, end);
       }
    }

    private static void moveZerosToEnd(int[] arr){
        int start = 0;
        int end = arr.length -1;

        while(start < end){

            while(arr[start] != 0){
                start ++;
            }
            if(start >= end){
                break;
            }
            if(arr[start] == 0){
                swap(arr, start, end);
            }
            start ++;
            end --;
        }


    }

    private static void swap(int[] arr, int start, int end){
        if(start < 0 || start >= arr.length || end < 0 || end >= arr.length){
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}