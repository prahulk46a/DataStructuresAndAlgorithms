package number_theory.minmax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []arr={15,17,25,39,47,52,29};

        MaxMinSecondMaxMin maxMinSecondMaxMin = new MaxMinSecondMaxMin();
        System.out.println("max min secondMax secondMin");
        System.out.println(Arrays.toString(maxMinSecondMaxMin.findMaxMin(arr)));
    }
}
