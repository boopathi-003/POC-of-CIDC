import java.util.*;
import java.util.Queue;
class queues {
    public void checkPriority(String[] num) {
        PriorityQueue<String> priority = new PriorityQueue<String>(Collections.reverseOrder());

        for (String j : num) {
            priority.add(j);
            System.out.println(priority);
        }

        while (!priority.isEmpty()) {
            System.out.print(priority.poll() + " ");
        }
    }
}
    class PrirorityQueu {
        public static void main(String[] args) {
            queues q = new queues();
            String[] str = new String[]{"89", "82", "70", "25", "16", "22", "36", "10", "14", "16", "16", "16"};
            q.checkPriority(str);
        }
    }

//import java.util.*;
//
//class Queue {
//    public void checkPriority(String[] num) {
//        Set<String> priority = new TreeSet<>();
//
//        for (String set : num) {
//            priority.add(set);
//        }
//        List<String> result = new LinkedList<>(priority);
//        for (int i = result.size() - 1; i >= 0; i--) {
//            System.out.print(result.get(i) + " ");
//        }
//    }
//
//}
//
//class PrirorityQueue {
//    public static void main(String[] args) {
//        Queue queue = new Queue();
//        String[] str = new String[]{"89", "82", "-70", "25", "16", "22", "36", "10", "14"};
//        queue.checkPriority(str);
//
//    }
//}
