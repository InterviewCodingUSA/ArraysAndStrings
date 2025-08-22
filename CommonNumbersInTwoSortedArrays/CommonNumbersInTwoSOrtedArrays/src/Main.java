import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {2,3,4};
        ArrayList<Integer> list = getCommonIntegers(arr1, arr2);
        for(Integer i : list){
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    private static ArrayList<Integer> getCommonIntegers(int[] arr1, int[] arr2){
        ArrayList<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while(index1 < arr1.length && index2 < arr2.length){
            if(arr1[index1] == arr2[index2]){
                list.add(arr1[index1]);
                index1++;
                index2++;
            }else if(arr1[index1] < arr2[index2]){
                index1++;
            }else{
                index2++;
            }
        }

        return list;
    }
}