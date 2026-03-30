import java.math.BigInteger;
import java.util.Scanner;

public class week8 {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter prime p: ");
            BigInteger p = sc.nextBigInteger();

            System.out.print("Enter prime q: ");
            BigInteger q = sc.nextBigInteger();

            BigInteger n = p.multiply(q);
            BigInteger phi = (p.subtract(BigInteger.ONE))
                             .multiply(q.subtract(BigInteger.ONE));

            // choose e
            BigInteger e = BigInteger.valueOf(2);
            while (!phi.gcd(e).equals(BigInteger.ONE))
                e = e.add(BigInteger.ONE);

            // find d
            BigInteger d = e.modInverse(phi);

            System.out.println("Public Key (e,n): (" + e + ", " + n + ")");
            System.out.println("Private Key (d,n): (" + d + ", " + n + ")");

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

// Enter prime p: 61
// Enter prime q: 57
// Public Key (e,n): (11, 3477)
// Private Key (d,n): (611, 3477)
