import java.security.MessageDigest;

public class week10 {
    public static void main(String[] args) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");

            // Info
            System.out.println("Message digest object info:");
            System.out.println("Algorithm = " + md.getAlgorithm());
            System.out.println("Provider = " + md.getProvider());
            System.out.println("ToString = " + md.toString());

            // Test inputs
            printHash(md, "");
            printHash(md, "abc");
            printHash(md, "abcdefghijklmnopqrstuvwxyz");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Function to print SHA1
    static void printHash(MessageDigest md, String text) {
        md.reset();
        byte[] hash = md.digest(text.getBytes());

        StringBuilder hex = new StringBuilder();
        for (byte b : hash)
            hex.append(String.format("%02X", b));

        System.out.println("\nSHA1(\"" + text + "\") = " + hex);
    }
}

// Message digest object info:
// Algorithm = SHA1
// Provider = SUN version 17
// ToString = SHA1 Message Digest from SUN, <initialized>


// SHA1("") = DA39A3EE5E6B4B0D3255BFEF95601890AFD80709

// SHA1("abc") = A9993E364706816ABA3E25717850C26C9CD0D89D

// SHA1("abcdefghijklmnopqrstuvwxyz") = 32D10C7B8CF96570CA04CE37F2A19D84240D3A89