//import javax.xml.soap.Node;
//import java.util.*;
//
//public class Solution {
//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        String str = scanner.nextLine();
////        String[] strList = str.split("\\s+");
////        ListNode head = new ListNode();
////        ListNode node = head;
////        for (int i = 0; i < strList.length; i++) {
////            System.out.println("i:"+i+"    len:"+str.length());
////            node.next=new ListNode(Integer.parseInt(strList[i]));
////            node=node.next;
////        }
////        head=head.next;
////        while (head!=null){
////            System.out.println("head:"+head.val);
////            head=head.next;
////        }
////        int m = scanner.nextInt();
////
////        System.out.println(m);
////        int a = 0;
////        char c = '\n';
////        System.out.println(Math.random());
////        HashMap<Integer, Integer> map = new HashMap<>(1);
////        map.put(1,1);
////        map.put(2,2);
////        map.put(1,map.getOrDefault(1,0)+1);
////        map.put(3,map.getOrDefault(3,0)+2);
////        System.out.println(map);
////        HashSet<Object> objects = new HashSet<>();
//
//        class TempNode{
//            int value;
//            TempNode next;
//            public TempNode(){}
//            public TempNode(int val){value=val;}
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        String[] strList = str.split(" ");
//        int[] a = new int[strList.length];
//        TempNode head = new TempNode();
//        TempNode aa = head;
//        for(int i=0;i<strList.length;i++){
//            aa.next=new TempNode(Integer.parseInt(strList[i]));
//            aa=aa.next;
//            a[i] = Integer.parseInt(strList[i]);
//        }
//        System.out.println(head);
//        head=head.next;
//        while (head!=null){
//            System.out.println(head.value);
//            head=head.next;
//        }
////        Arrays.sort(a);
////        System.out.println(a);
////        for (int i = 0; i < a.length; i++) {
////            System.out.println(a[i]);
////        }
//        scanner.close();
//
//
////        String str = " a  b c      d";
////        System.out.println(str);
////        //四种分隔符
////        String[] arr1 = str.split(" ");
////        String[] arr2 = str.split("s");
////        String[] arr3 = str.split("\t");
////        String[] arr4 = str.split("\\s+");
////
//////打印
////        for (String s : arr1) {
////            System.out.print(s+",");
////        }
////        System.out.println("");
////        for (String s : arr2) {
////            System.out.print(s+",");
////        }
////        System.out.println("");
////        for (String s : arr3) {
////            System.out.print(s+",");
////        }
////        System.out.println("");
////        for (String s : arr4) {
////            System.out.print(s+",");
////        }
////        System.out.println();
////        for (String s : arr4) {
////            System.out.print(s);
////        }
//    }
//}
