import java.util.*;
public class anagram
{
    static void anagg(String a,String b) {
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        String str1 = new String(ch1);
        String str2 = new String(ch2);
        if (str1.contentEquals(str2)){
            System.out.println("anagram");
        } else {
            System.out.println("no anag");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        anagg(a,b);
    }
}

