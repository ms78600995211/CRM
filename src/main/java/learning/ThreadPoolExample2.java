package learning;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample2 {

    public static void main(String[] args) {
        // Create a ThreadPoolExecutor with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Create a list to hold the Future objects
        List<Future<String>> futures = new ArrayList<>();
        
        // Submit tasks to the thread pool
        for (int i = 0; i < 5; i++) {
            Callable<String> task = new Task1("Task " + i);
            Future<String> future = executor.submit(task);
            futures.add(future);
        }

        // Shutdown the executor, no new tasks will be accepted, but already submitted tasks will continue
        executor.shutdown();

        // Wait for all tasks to complete
        for (Future<String> future : futures) {
            try {
            	System.out.println("is Done ?  :::"+future.isDone());
                String result = future.get();
                System.out.println("result==============="+result);
            	System.out.println("is Done ?  :::"+future.isDone());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All tasks have completed.");
    }
}
