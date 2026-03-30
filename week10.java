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
