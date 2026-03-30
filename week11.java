import java.security.MessageDigest;
import java.util.Scanner;

public class week11 {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter text to hash using MD5: ");
            String input = sc.nextLine();

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());

            // Convert to hex
            StringBuilder hex = new StringBuilder();
            for (byte b : hashBytes)
                hex.append(String.format("%02X", b));

            System.out.println("MD5 hash of \"" + input + "\" is:");
            System.out.println(hex);

            sc.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

// Enter text to hash using MD5: bina
// MD5 hash of "bina" is:
// AF7C14172FD3062C434BC56CB99FA703