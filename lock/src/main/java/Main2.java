import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
    static final ResourceA resourceA = new ResourceA();
    static final ResourceB resourceB = new ResourceB();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->resourceA.doSome(resourceB));
        executorService.submit(()->resourceB.doSome(resourceA));
    }
}
