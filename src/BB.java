import java.util.ArrayList;
import java.util.Scanner;

public class BB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] s1 = s.split(" ");
        int n = s1.length;
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = Integer.valueOf(s1[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = (j-i)*Math.min(height[j],height[i]);
                if(temp>result) result=temp;
            }
        }
        //3 9 6 7 8 5 9 7 6 8 9
        System.out.println(result);
    }
}
