package number_theory.minmax;

public class MaxMinSecondMaxMin {
    public int[] findMaxMin(int[]arr){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int secondMax=Integer.MIN_VALUE;
        int secondMin=Integer.MAX_VALUE;

        if (arr.length < 2) {
            System.out.println("Array must contain at least two elements");
            return new int[0];
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                secondMax=max;
                max=arr[i];
            }
            else if(arr[i]!=max && secondMax<arr[i]){
                secondMax=arr[i];
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                secondMin=min;
                min=arr[i];
            }
            else if(arr[i]!=min && secondMin>arr[i]){
                secondMin=arr[i];
            }
        }

        return new int[]{max,min,secondMax,secondMin};

    }

}
