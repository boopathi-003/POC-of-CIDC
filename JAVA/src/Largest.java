import java.util.*;

class Largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        
        int large = Math.max(num1, Math.max(num2, num3));
        
        System.out.println("The largest number is: " + large);
    }
}
