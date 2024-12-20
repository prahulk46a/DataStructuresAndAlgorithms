package number_theory.string_to_integer;

public class Main {
    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        int ans1=atoi.myAtoi("-042");    //-42
        int ans2=atoi.myAtoi("+-042");   //0
        int ans3=atoi.myAtoi("42");      //42
        int ans4=atoi.myAtoi("0-1");     //0
        int ans5=atoi.myAtoi("011");     //11
        int ans6=atoi.myAtoi("1337cdsld12");        //1337
        int ans7=atoi.myAtoi("-1337256752134569852655");        //Integer.MIN_VALUE=>-2147483648


        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);
        System.out.println(ans5);
        System.out.println(ans6);
        System.out.println(ans7);

    }
}
