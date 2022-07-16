import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,20,1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1000),new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 1000; i++) {
            Callable callable = new PrintClass2(""+i);
            threadPoolExecutor.submit(callable);
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){
        }
        System.out.println("Finished all thread");
    }
}
