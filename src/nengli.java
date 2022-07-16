import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class nengli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(scanner.nextInt());

        }
        int m = scanner.nextInt();
        int res = 0;
        while (true){
            Integer poll = deque.poll();
            System.out.println(deque);
            if(poll<deque.peek()){
                res++;
                deque.add(poll);
                continue;
            }
            int count=0;
            Deque<Integer> temp = new LinkedList<>();
            while (count!=m&&poll>deque.peek()){
                System.out.println("deque:"+deque+"   temp:"+temp);
                res++;
                count++;
                temp.add(deque.poll());
                System.out.println("2222deque:"+deque+"   temp:"+temp+"   count:"+count+"   res:"+res);
            }
            if(count==m){
                System.out.println("res:"+res);
                break;
            }else {
                while (!deque.isEmpty()){
                    temp.add(deque.poll());
                }
                deque = temp;
            }
        }
    }
}
