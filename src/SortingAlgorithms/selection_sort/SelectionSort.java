package SortingAlgorithms.selection_sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[]arr={1,3,9,7,4,2};
        int[] ans=optimisedSelectionSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] selectionSort(int[] arr) {
        //o(n^2) with multiple swaps
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }


    private static int[] optimisedSelectionSort(int[] arr) {
        //o(n^2) with minimum swaps
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            //Find/Select minimum and keep that min at right place
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }

            // Swap only once per outer loop iteration
            if(min!=i){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
        return arr;
    }



}
