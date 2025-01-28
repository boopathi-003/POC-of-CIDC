import java.util.Scanner;

import static java.lang.Integer.*;

//
//import java.util.*;
//
//public class Palindrome {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String reverseStr = new StringBuilder(str).reverse().toString();
//
//        if (str.equals(reverseStr)) {
//            System.out.println(str + " is a palindrome.");
//        } else {
//            System.out.println(str + " is not a palindrome.");
//        }
//
//    }
//}
class CheckPalindrome {
    String result;
    int max = Integer.MIN_VALUE;
    public void IsPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                StringBuilder sb = new StringBuilder(str.substring(i, j));
                String str1 = str.substring(i, j);
                if (str1.equals(sb.reverse().toString())) {
                    if(sb.length()>max) {
                        max = Math.max(max, sb.length());
                        result = str1;
                    }
                }
            }
        }
        System.out.println("res  "+result);
    }
}

class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        CheckPalindrome c = new CheckPalindrome();
        c.IsPalindrome(str);
    }
}