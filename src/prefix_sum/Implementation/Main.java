package prefix_sum.Implementation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8,9,10};
        PrefixImpl prefix = new PrefixImpl();
        int [] prefixSumArray=PrefixImpl.prefixSum(arr);
        System.out.println(Arrays.toString(prefixSumArray));

        int ans=prefix.rangeSum(arr, 0,3);//10
        System.out.println(ans);


    }
}
