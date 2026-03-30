import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class week5 {
    // public static void main(String[] args) throws Exception {

    //     Scanner sc = new Scanner(System.in);
    //     System.out.print("Enter text: ");
    //     String text = sc.nextLine();

    //     // Secret key
    //     SecretKeySpec key = new SecretKeySpec("key123".getBytes(), "Blowfish");

    //     // Encrypt
    //     Cipher c = Cipher.getInstance("Blowfish");
    //     c.init(Cipher.ENCRYPT_MODE, key);
    //     String enc = Base64.getEncoder().encodeToString(c.doFinal(text.getBytes()));

    //     // Decrypt
    //     c.init(Cipher.DECRYPT_MODE, key);
    //     String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));

    //     System.out.println("Encrypted: " + enc);
    //     System.out.println("Decrypted: " + dec);
    // }
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // Secret key
            SecretKeySpec key = new SecretKeySpec("key123".getBytes(), "Blowfish");

            // Cipher
            Cipher c = Cipher.getInstance("Blowfish");

            // Encrypt
            c.init(Cipher.ENCRYPT_MODE, key);
            String enc = Base64.getEncoder().encodeToString(c.doFinal(text.getBytes()));

            // Decrypt
            c.init(Cipher.DECRYPT_MODE, key);
            String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));

            System.out.println("Encrypted: " + enc);
            System.out.println("Decrypted: " + dec);

            sc.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

// Enter text: bina
// Encrypted: HvLRdJ1mHkU=
// Decrypted: bina
