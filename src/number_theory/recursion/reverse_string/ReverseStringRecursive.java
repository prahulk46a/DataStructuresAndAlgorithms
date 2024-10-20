package number_theory.recursion.reverse_string;

public class ReverseStringRecursive {
    public String reveseString(String str) {
        if(str.length()==0){
            return str;
        }
        return reveseString(str.substring(1)) + str.charAt(0);

    }
}
