import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class week6 {
    public static void main(String[] args) {
        try {
            // Generate key
            SecretKey key = KeyGenerator.getInstance("AES").generateKey();

            String text = "Hello AES";

            // Encrypt
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, key);
            String enc = Base64.getEncoder().encodeToString(c.doFinal(text.getBytes()));

            // Decrypt
            c.init(Cipher.DECRYPT_MODE, key);
            String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));

            System.out.println("Encrypted: " + enc);
            System.out.println("Decrypted: " + dec);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Encrypted: 6inM4wOk/2YSb1JIcrY3yA==
// Decrypted: Hello AES
