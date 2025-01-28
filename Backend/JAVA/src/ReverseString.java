import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        String reverseStr = new StringBuilder(str).reverse().toString();
        
        System.out.println("Reversed string: " + reverseStr);
   
    }
}
