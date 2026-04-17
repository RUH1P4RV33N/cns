import java.util.Scanner;

public class week3c {

    static int modInverse(int a) {
        a = (a % 26 + 26) % 26;
        for (int x = 1; x < 26; x++) {
            if ((a * x) % 26 == 1)
                return x;
        }
        return -1;
    }

    static int determinant(int[][] m) {
        int det = m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
                - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
                + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
        return (det % 26 + 26) % 26;
    }

    static void adjoint(int[][] m, int[][] adj) {
        adj[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        adj[0][1] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        adj[0][2] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        adj[1][0] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        adj[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        adj[1][2] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);

        adj[2][0] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
        adj[2][1] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        adj[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]);
    }

    static void inverse(int[][] key, int[][] inv) {
        int det = determinant(key);
        int invDet = modInverse(det);

        if (invDet == -1) {
            System.out.println("Inverse does not exist!");
            System.exit(0);
        }

        int[][] adj = new int[3][3];
        adjoint(key, adj);

        // transpose + multiply with inverse determinant
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inv[i][j] = (adj[j][i] * invDet) % 26;
                inv[i][j] = (inv[i][j] + 26) % 26;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] key = new int[3][3];
        int[][] msg = new int[3][1];
        int[][] res = new int[3][1];
        int[][] inv = new int[3][3];
        int[][] dec = new int[3][1];

        System.out.println("Enter 3x3 key matrix:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                key[i][j] = sc.nextInt();

        System.out.print("Enter 3-letter message: ");
        String text = sc.next().toUpperCase();

        for (int i = 0; i < 3; i++)
            msg[i][0] = text.charAt(i) - 'A';

        // Encryption
        for (int i = 0; i < 3; i++) {
            res[i][0] = 0;
            for (int j = 0; j < 3; j++) {
                res[i][0] += key[i][j] * msg[j][0];
            }
            res[i][0] = (res[i][0] % 26 + 26) % 26;
        }

        // Compute inverse automatically
        inverse(key, inv);

        // Decryption
        for (int i = 0; i < 3; i++) {
            dec[i][0] = 0;
            for (int j = 0; j < 3; j++) {
                dec[i][0] += inv[i][j] * res[j][0];
            }
            dec[i][0] = (dec[i][0] % 26 + 26) % 26;
        }

        // Output
        System.out.print("Encrypted: ");
        for (int i = 0; i < 3; i++)
            System.out.print((char)(res[i][0] + 'A'));

        System.out.print("\nDecrypted: ");
        for (int i = 0; i < 3; i++)
            System.out.print((char)(dec[i][0] + 'A'));
    }
}

// Enter 3x3 key matrix:
// 6 24 1
// 13 16 10
// 20 17 15
// Enter 3-letter message:
// ACT

// Encrypted: POH
// Decrypted: ACT
