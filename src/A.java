public class A{
    private static boolean flag = true;
    public static void main(String[] args) {
        int[] xixi = {1};
        new Thread(()->{
            while (true){
                while (flag&&xixi[0]<100){
                    System.out.println("嘻嘻嘻嘻:"+xixi[0]++);
                    flag =false;
                }
            }
        }).start();
        new Thread(()->{
            while (true){
                while (!flag&&xixi[0]<100){
                    System.out.println("哈哈哈:"+xixi[0]++);
                    flag=true;
                }
            }
        }).start();
    }
}
