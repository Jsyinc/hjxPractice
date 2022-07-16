package xixi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<int[]> block = new ArrayList<>();
        int pre=1;
        while(true){
            int index1 = s.indexOf('[',pre);
            if(index1==-1) break;
            int index2 = s.indexOf(']',pre);
            String t=s.substring(index1+1,index2);
            String[] tmp = t.split(",");
            int[] a = new int[]{Integer.valueOf(tmp[0],Integer.valueOf(tmp[1]))};
            block.add(a);
            pre=index2+1;
        }
        int[][] array = new int[block.size()][2];
        int count=0;
        for (int i = 0; i < block.size(); i++) {
            int[] ints = block.get(i);
            array[i][0] = ints[0];
            array[]
        }

//
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
//        String[] s = str.split(" ");
//        int len = s.length;
//        int[][] array = new int[len/2][2];
//        int count=0;
//        for (int i = 0; i < len; i=i+2) {
//            array[count][0]=Integer.valueOf(s[i]);
//            array[count][1]=Integer.valueOf(s[i+1]);
//            count++;
//        }
//        System.out.println(erase(array));
    }

    private static int erase(int[][] intervals) {
        if(intervals==null||intervals.length==0) return 0;
        Arrays.sort(intervals,new Comparator<int []>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int res=1,pre=0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=intervals[pre][1]){
                res++;
                pre=i;
            }
        }
        return intervals.length-res;
    }
}
