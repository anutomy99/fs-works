package Thread;

import java.util.concurrent.*;

class  CallableTask implements Callable<String>{
    private String name;

    public  CallableTask(String name){
        this.name= name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello  "+name;
    }
}
public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> callbackVar = executorService.submit(new CallableTask("Anu"));
        String returnMsg = callbackVar.get();
        System.out.println(returnMsg);
    }
}
