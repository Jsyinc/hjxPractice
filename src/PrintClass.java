public class PrintClass {
    int i = 1;
    public synchronized void printA(){
        while (i<100){
            System.out.println(Thread.currentThread().getName()+"  "+i++);
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
