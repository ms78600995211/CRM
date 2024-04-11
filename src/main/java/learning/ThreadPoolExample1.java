package learning;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample1 {

	public static void main(String[] args) {
		// Create a ThreadPoolExecutor with 1 thread
		ExecutorService executor = Executors.newFixedThreadPool(1); 
		
		// Submit tasks to the thread pool
		for (int i = 0; i < 5; i++) {
			Runnable task = new Task("Task " + i);
			executor.submit(task);
		}

		// Shutdown the executor, no new tasks will be accepted, but already submitted
		// tasks will continue
		executor.shutdown();
		try {
			// Wait for all tasks to finish or until timeout of 30 seconds
			boolean status= executor.awaitTermination(5, TimeUnit.SECONDS);
			if(!status) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All tasks have completed.");
	}
}
