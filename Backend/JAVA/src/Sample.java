import java.util.Scanner;

class  Test{
    private int num;
    Test(int num)
    {
        this.num=num;
    }
    public  void addOrEven(){
        String result = (num%2==0)?"even":"odd";
        System.out.println("Given number is "+result);
    }
    public  void numberToWords(){
        int number =num;
        String  result ="";

        //for negative value
        if(num<0)  {
          number = -1 * num;
        }

        //for zero
       if(number == 0){
           result="Zero";
       }

       else{
           result =  getwords(number%1000);
            number = number / 1000;
            if (number > 0 && number % 100 > 0) {
                result = getwords(number % 100) + "thousand " + result;
            }
            number = number / 100;
            if (number > 0 && number % 1000 > 0) {
                result = getwords(number % 1000) + "Lakh " + result;
            }
            number = number / 1000;
            if (number > 0 && number % 1000 > 0) {
                result = getwords(number % 1000) + "Million " + result;
            }
            number = number / 1000;
            if (number > 0) {
                result = getwords(number % 1000) + "Billion " + result;
            }
        }
        //output
        if(num<0){
            System.out.println("Given input in words : "+"Minus "+ result );
        }
        else {
            System.out.println("Given input in words : " + result);
        }
    }

    private String getwords(int num) {
        String[] digitString = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teenString = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
        String[] tenString = new String[]{"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String result = "";
        if(num > 99){
            result += digitString[num/100] + " Hundred and ";
        }
        num = num % 100;
        if(num < 20 && num > 9){
            result += teenString[num%10]+" ";
        }
        else{
            if(num > 19){
                result += tenString[num/10]+" ";
            }
            num = num % 10;
            if(num > 0)
                result += digitString[num]+" ";
        }
        return result;
    }
}
public class Sample {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int input = sc.nextInt();
        Test test = new Test(input);
        test.addOrEven();
        test.numberToWords();
    }
}
