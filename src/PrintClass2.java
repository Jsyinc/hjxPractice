import java.util.Date;
import java.util.concurrent.Callable;

public class PrintClass2 implements Callable {

    private String command;

    public PrintClass2(String s) {
        this.command = s;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("第"+this.command+"个任务       "+Thread.currentThread().getName()+"    StartTime:"+new Date());
        processCommand();
        return true;
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
