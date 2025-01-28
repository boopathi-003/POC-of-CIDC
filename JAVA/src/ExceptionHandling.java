import java.util.*;
class ThrowExcep
{
    public boolean CheckVowels(String str)
    {
        boolean isVowels = false;
        for(int i=0;i<str.length();i++)
        {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'
                    || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U')
            {
                isVowels=true;
                break;
            }
        }
        return isVowels;
    }
}
public class ExceptionHandling {
    public static void main(String[] args) {
        try{
            ThrowExcep T = new ThrowExcep();
            Scanner sc=new Scanner(System.in);
            String s= "bb";


            boolean isVowels = T.CheckVowels(s);

            if(!isVowels) {

                throw new NoSuchElementException("Vowels are not present in the word");
            }
            else{
                System.out.println("Vowels are present in the word");
            }
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("final");
        }
        System.out.println("hii");
    }


}

