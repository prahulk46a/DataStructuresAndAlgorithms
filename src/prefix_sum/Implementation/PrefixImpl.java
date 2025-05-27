package prefix_sum.Implementation;

public class PrefixImpl {
    public static int[] prefixSum(int []arr){
        int[]ans=new int[arr.length];
        int sum=0;
        //Core Logic
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            ans[i] = sum;
        }
        return ans;
    }

    // sum of an array element at index Inclusive(l&R) => using prefix sum
    int rangeSum(int []nums,int left,int right){
        int[]arr=prefixSum(nums);


        if(left==0) return arr[right];
        return arr[right]-arr[left];


    }
}
