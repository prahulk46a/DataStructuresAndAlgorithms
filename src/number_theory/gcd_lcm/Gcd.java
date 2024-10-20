package number_theory.gcd_lcm;

public class Gcd {
    public int gcdUsingWhile(int a, int b) {
        int result=Math.min(a,b);
        while(result>0){
            if(result%a==0 && result%b==0){
                break;
            }
            result--;
        }
        return result;
    }

    public int gcdUsingRecursion(int a, int b) {
        if(b>a){
            return gcdUsingRecursion(b,a);
        }
        //Whichever is bigger divide to that no by other till we dont get 0
        if(b==0){
            return a;
        }
        return gcdUsingRecursion(b,a%b);
    }
}
