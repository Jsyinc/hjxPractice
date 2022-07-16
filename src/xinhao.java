import java.util.concurrent.Semaphore;

public class xinhao {
    public static void main(String[] args) {
        Semaphore fooSema = new Semaphore(1);
        Semaphore barSema = new Semaphore(0);
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    fooSema.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("AAAAAAAAAAAAAAAA"+"     "+i);
                barSema.release();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    barSema.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("BBBBBBBBBBBBBBBBBB"+"       "+i);
                fooSema.release();
            }
        }).start();
    }
}