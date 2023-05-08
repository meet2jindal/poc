package poc.completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public String placeOrder() {
        return "Order Placed";
    }

    public String packOrder() {
        return "Order Packed";
    }

    public String deliverOrder() {
        return "Order Delivered";
    }

    public String sendEmail() {
        return "Send Email - Order Delivered";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->completableFutureDemo.placeOrder())
                .thenApplyAsync(str -> completableFutureDemo.packOrder())
                .thenApplyAsync(str-> completableFutureDemo.deliverOrder())
                .thenApplyAsync(str->completableFutureDemo.sendEmail());
        final String s = completableFuture.get();
        System.out.println(s);
        
    }
}
