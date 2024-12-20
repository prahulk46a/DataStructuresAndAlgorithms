package number_theory.sieve_of_eratosthenes;

public class Sieve {
    public static void findPrime(int range){
        boolean[] primes = new boolean[range+1];
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= range; i++) {
            primes[i] = true;
        }

        for (int i = 2; i <=Math.sqrt(range) ; i++) {

            if(primes[i]){  // At any point if i is prime then next all multiple of that number will be non-prime
                for(int j = i*i; j <= range; j+=i){
                    primes[j] = false;
                }

            }
        }

        System.out.println("Prime numbers up to " + range + ":");
        for (int i = 2; i <= range; ++i) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }


    }
}
