package number_theory.reverse;

public class ReverseNo {
    public  int reverseNumber(int num) {
        int rev=0;

        while(num!=0){
            rev=rev*10+num%10;
            num=num/10;
        }
        return rev;
    }

}
