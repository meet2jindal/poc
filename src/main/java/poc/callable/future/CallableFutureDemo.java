package poc.callable.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo {

    Callable<String> placeOrderTask = () -> {
        String task = "Order placed";
        System.out.println(task);
        return task;
    };
    Callable<String> packOrderTask = () -> {
        String task = "Order Packed";
        System.out.println(task);
        return task;

    };
    Callable<String> deliverOrderTask = () -> {
        String task = "Order Delivered";
        System.out.println(task);
        return task;

    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableFutureDemo completableFutureDemo = new CallableFutureDemo();


        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 50; i++) {


            final Future<String> futurePlaceOrder = service.submit(completableFutureDemo.placeOrderTask);
            System.out.println(futurePlaceOrder.get());

            final Future<?> futurePackOrder = service.submit(completableFutureDemo.packOrderTask);
            System.out.println(futurePackOrder.get());

            final Future<?> futureDeliverOrder = service.submit(completableFutureDemo.deliverOrderTask);
            System.out.println(futureDeliverOrder.get());
        }
    }
}
