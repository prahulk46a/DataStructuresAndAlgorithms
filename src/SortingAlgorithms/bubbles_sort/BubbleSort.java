package SortingAlgorithms.bubbles_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[]arr={1,3,9,7,4,2};
        int[] ans=bubbleSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean flag=true;
        for(int i=0;i<n;i++) {
            flag=false;
            for(int j=1;j<n-i;j++) {    //This here n-i is there to skip last i element to skip as they will be at correct position always

                if(arr[j]<arr[j-1]) {
                    flag=true;          // This flag is there as there is no swapping occurs that  means array is sorted
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;

                }

            }
            if(flag==false) {
                break;
            }

        }
        return arr;
    }



}
