package learning;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        // Create an ExecutorService with a WorkStealingPool
        ExecutorService executor = Executors.newWorkStealingPool();

        // List of Callable tasks
        List<Callable<String>> callables = Arrays.asList(
                newCallable("Task 1", 3),
                newCallable("Task 2", 2),
                newCallable("Task 3", 1)
        );

        // List to hold the Future results of each task
        List<Future<String>> futures = executor.invokeAll(callables);

        // Iterate through the Futures to get the results
        for (Future<String> future : futures) {
            try {
                // Get the result of each task (this will block until the result is available)
                String result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                // Handle any exceptions that occurred during execution
                e.printStackTrace();
            }
        }

        // Shut down the executor
        executor.shutdown();
    }

    // Method to create a new Callable task
    private static Callable<String> newCallable(String s, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return "Returning after Sleeping " + sleepSeconds + " seconds for " + s;
        };
    }
}
