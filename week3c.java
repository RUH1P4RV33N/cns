import java.util.Scanner;

public class week3c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] key = new int[3][3];
        int[][] msg = new int[3][1];
        int[][] res = new int[3][1];
        int [][] inv= new int[3][3];
        int [][] dec=new int[3][1];
        System.out.println("Enter 3x3 key matrix:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                key[i][j] = sc.nextInt();

        System.out.print("Enter 3-letter message: ");
        String text = sc.next().toUpperCase();

        // Convert text to numbers
        for (int i = 0; i < 3; i++)
            msg[i][0] = text.charAt(i) - 'A';

        // Matrix multiplication
        for (int i = 0; i < 3; i++) {
            res[i][0] = 0;
            for (int j = 0; j < 3; j++) {
                res[i][0] += key[i][j] * msg[j][0];
            }
            res[i][0] =(res[i][0]%26+26)%26;
        }

         System.out.println("Enter 3x3 inv matrix:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inv[i][j] = sc.nextInt();

        for(int i=0;i<3;i++)
        {
            dec[i][0]=0;
            for(int j=0;j<3;j++)
            {
                dec[i][0]+=(inv[i][j]*res[j][0]);
            }
            dec[i][0]=(dec[i][0]%26+26)%26;
        }

        // Convert back to text 
        System.out.println("Encrypted: ");
        for (int i = 0; i < 3; i++)
            System.out.print((char)(res[i][0] + 'A'));
        
        System.out.println("\nDecryption: ");
        for (int i = 0; i < 3; i++)
            System.out.print((char)(dec[i][0] + 'A'));
    }
}
