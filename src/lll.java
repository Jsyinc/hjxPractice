import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class lll {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] s1 = s.split(" ");
        int n = s1.length;
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = Integer.valueOf(s1[i]);
        }

        int len = array1.length;
        int min=0,max=0;
        for (int i = 0; i < len; i++) {
            if(array1[min]>array1[i]) min=i;
            if(array1[max]<array1[i]) max=i;
        }
        int zero = array1[0];
        int b = array1[len-1];
        array1[0]=array1[min];
        array1[min]=zero;
        array1[len-1]=array1[max];
        array1[max]=b;

        System.out.println("==================");
        for (int i = 0; i < len; i++) {
            System.out.println(array1[i]);
        }
    }
}
