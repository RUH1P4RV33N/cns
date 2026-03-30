import java.util.*;

public class week3b {
    static String normal = "abcdefghijklmnopqrstuvwxyz ";
    static String cipher = "zyxwvutsrqponmlkjihgfedcba ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine().toLowerCase();

        String enc = convert(text, normal, cipher);
        String dec = convert(enc, cipher, normal);

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }

    static String convert(String text, String from, String to) {
        StringBuilder res = new StringBuilder();

        for (char c : text.toCharArray()) {
            int i = from.indexOf(c);
            res.append(i != -1 ? to.charAt(i) : c);
        }

        return res.toString();
    }
}


// Enter text: bina
// Encrypted: yrmz
// Decrypted: bina