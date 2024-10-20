package number_theory.recursion.recursive_sum;

public class Add {
    public int sumOfFirstN(int n) {
        // Base case: If n is 1 or less, return n
        if (n <= 1) {
            return n;
        }
        // Recursive case: Sum of n + sum of first (n-1) numbers
        return n + sumOfFirstN(n - 1);
    }
}
