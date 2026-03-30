import java.util.*;
public class week3 {
    public static void main(String args [])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String s=sc.nextLine();
        int key=sc.nextInt();
        String enc=convert(s,key);
        String dec=convert(enc,-key);
        System.out.println("encoded:"+enc);
        System.out.println("decoded:"+dec);

    }
    public static String convert(String s,int key)
    {
        StringBuilder sb=new StringBuilder();
        char ch[]=s.toCharArray();
        for(char c:ch){
              if(Character.isUpperCase(c))
              {
                  sb.append((char)((c-'A'+key+26)%26+'A'));
              }
              else if(Character.isLowerCase(c))
              {
                  sb.append((char)((c-'a'+key+26)%26+'a'));
              }
              else
                sb.append(c);
        }
        return sb.toString();

        
    }
    

}

