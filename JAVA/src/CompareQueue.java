import java.util.PriorityQueue;
import java.util.Arrays;
public class CompareQueue {
    public static void main(String[] args) {
        PriorityQueue<String> str = new PriorityQueue<>(Arrays.asList("Black", "Red", "Green", "White"));
        PriorityQueue<String> str1 = new PriorityQueue<>(Arrays.asList("Black", "Orange", "Pink", "Red"));
        for (String str3 :str){
            if(str1.contains(str3))
            {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }

        }
    }
}