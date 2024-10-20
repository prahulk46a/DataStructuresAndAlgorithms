package number_theory.fibonacci;

public class FibonacciSeries {
    static int n1=0,n2=1,n3=0;
    public static void fiboWithRecurssion(int count){
        if(count>0){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" "+n3);
            fiboWithRecurssion(count-1);
        }
    }
}
