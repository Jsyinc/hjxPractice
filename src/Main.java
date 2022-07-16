import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    /* Write Code Here */
    public String[] delMinFrequencyChar(String[] input) {
        int len1 = input.length;
        String[] res = new String[len1];
        if (0 == len1) return new String[0];
        String[] str = new String[len1];
        for (int j = 0; j < len1; j++) {
            String temp = input[j];
            int min = Integer.MAX_VALUE;
            Map<Character, Integer> map = new HashMap<>();
            char[] arr = temp.toCharArray();
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                char a = arr[i];
                map.put(a, map.getOrDefault(a, 0) + 1);
                min = Math.min(min, map.get(a));
            }
            Set<Character> set = new HashSet<>();
            for (Character a : map.keySet()) {
                if (map.get(a) == min) {
                    set.add(a);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (!set.contains(arr[i])) {
                    sb.append(arr[i]);
                }
            }
            //System.out.println(sb.toString()+"   vvv");
            res[j]=sb.toString();
        }
        return res;
    }
//            String temp = input[i];
//            HashMap<Character,Integer> map = new HashMap<>();
//            int size = temp.length();
//            for (int i1 = 0; i1 < size; i1++) {
//                map.put(temp.charAt(i1),map.getOrDefault(temp.charAt(i1),0)+1);
//            }
//            int min = Integer.MAX_VALUE;
//            for (Map.Entry<Character,Integer> entry:map.entrySet()){
//                if (entry.getValue()<min){
//                    min=entry.getValue();
//                }
//            }
//            List<String> list = new ArrayList<>();
//            for (Map.Entry<Character,Integer> entry:map.entrySet()){
//                if (entry.getValue()==min){
//                    list.add(String.valueOf(entry.getKey()));
//                }
//            }
//            for (int k=0;k<list.size();k++){
//                temp = temp.replace(list.get(k),"");
//            }
//            System.out.println(temp);
//            str[i]=temp;
//        }
//        return str;
//    }
}

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        Deque<Integer> max = new LinkedList();
        Deque<Integer> min = new LinkedList();
        double res = Integer.MIN_VALUE*1.0;
        int pos = 1;
        double now = 0;
        for(int i=0;i<m;i++){
            now+=arr[i];
            while(!max.isEmpty()&&max.peekLast()<arr[i]){
                max.removeLast();
            }
            max.addLast(arr[i]);
            while(!min.isEmpty()&&min.peekLast()>arr[i]){
                min.removeLast();
            }
            min.addLast(arr[i]);
        }
        res = (now-max.peekFirst()-min.peekFirst())*1.0/(m-2);
        int p=0;
        for(int j=m;j<n;j++){
            int t=arr[j];
            int t1 = arr[p];
            p++;
            now-=t1;
            now+=t;
            if(max.peekFirst()==t1) max.pop();
            if(min.peekFirst()==t1) min.pop();
            while(!max.isEmpty()&&max.peekLast()<t) max.removeLast();
            max.addLast(t);
            while(!min.isEmpty()&&min.peekLast()>t) min.removeLast();
            min.addLast(t);
            double temp = (now-max.peekFirst()-min.peekFirst())/(m-2);
            if(temp>res){
                res=temp;
                pos=j+1;
            }
        }
        System.out.println(pos);
    }
}
