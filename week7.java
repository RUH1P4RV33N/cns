import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class week7 {
    public static void main(String[] args) {

        try {
            String key = "12345678";   // at least 8 bytes
            String text = "Hello World";

            SecretKeySpec k = new SecretKeySpec(key.getBytes(), "Blowfish");
            Cipher c = Cipher.getInstance("Blowfish");

            // Encrypt
            c.init(Cipher.ENCRYPT_MODE, k);
            String enc = Base64.getEncoder().encodeToString(c.doFinal(text.getBytes()));

            // Decrypt
            c.init(Cipher.DECRYPT_MODE, k);
            String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));

            System.out.println("Encrypted: " + enc);
            System.out.println("Decrypted: " + dec);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// Encrypted: gaWE09IV1nQUl6gi3Ror8A==
// Decrypted: Hello World