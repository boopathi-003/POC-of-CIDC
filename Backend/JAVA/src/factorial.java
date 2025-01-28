import java.util.*;
 class factorial {  
    static int factors(int n){      
          if (n == 1)      
            return 1;      
          else      
            return(n * factors(n-1));      
    }      
  
public static void main(String[] args) {  
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
System.out.println("Factorial of 5 is: "+factors(n));  
}  
}  