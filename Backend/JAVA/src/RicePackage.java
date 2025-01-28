import java.util.Scanner;

class Package
{
    public  boolean RicePackage(int small,int big,int goal)
    {
        boolean isPackage = false;
        int totalKg = (small*1)+(big*5);
        if(totalKg==goal && small>0 && big>0)
        {
            isPackage=true;
        }
        return isPackage;
    }
}
public class RicePackage {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Package p=new Package();
        int small=sc.nextInt();
        int big=sc.nextInt();
        int goal=sc.nextInt();
        System.out.println(p.RicePackage(small,big,goal));
    }
}
