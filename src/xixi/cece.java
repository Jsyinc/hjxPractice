package xixi;

import java.util.*;

public class cece {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        String res = n+"=";
//        Deque<Integer> deque = new LinkedList();
//        for(int i=2;i<n;i++){
//            while(n%i==0){
//                if(n==i) break;
//                else deque.add(i);
//                n=n/i;
//            }
//        }
//        while(!deque.isEmpty()){
//            res = res+deque.poll()+"*";
//        }
//        System.out.println(res+n);

//        short sum = 1;
//        sum = (short) (sum+1);
//        sum+=sum;
//        System.out.println(sum+1);
//        String s ="dfgdf";
//        String s1 = s.substring(1,s.length());
//        String replace = s.replace('d', 's');
//        System.out.println(s);
//        System.out.println(s1);
//        char[] chars = s.toCharArray();

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        ArrayList<List<Integer>> res = new  ArrayList<>();
//        backtrack(list.size(),list,res,0);
//        System.out.println(res);


        HashMap<Integer,int[][]> map = new HashMap<>();
        int[][] a = new int[1][2];
        a[0][0] = 1;
        a[0][1] = 1;
        map.put(1,a);
        int[][] temp = map.get(1);
        System.out.println(temp[0][0]+"   "+temp[0][1]);
    }
    private static void backtrack(int n,List<Integer> output,List<List<Integer>> res,int first){
        System.out.println("res:"+res+"   output:"+output+"  first:"+first);
        // 所有数都填完了
        if (first == n) {
            System.out.println("==============");
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            System.out.println("======"+output+"   i:"+i+"   first:"+first);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
