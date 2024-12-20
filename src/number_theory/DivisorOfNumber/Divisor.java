package number_theory.DivisorOfNumber;

public class Divisor {
    public static int divisor(int num) {
        //Optimal Approach=> TC o(sqrt(n))
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return i;
            }
        }
        return -1;
    }
}
