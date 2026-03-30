import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class week4 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Generate key
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();

        // Create cipher
        Cipher cipher = Cipher.getInstance("DES");

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, key);
        String enc = Base64.getEncoder().encodeToString(
                cipher.doFinal(text.getBytes()));

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, key);
        String dec = new String(
                cipher.doFinal(Base64.getDecoder().decode(enc)));

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}

// Enter text: bina
// Encrypted: YdxneKUBWZo=
// Decrypted: bina
