package learning;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class ThreadPoolExample {

	public static void main(String[] args) {
		ThreadPoolExecutor executer=new ThreadPoolExecutor(2,4,10,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(2),new ThreadPoolExecutor.DiscardOldestPolicy());
//		ThreadPoolExecutor executer=new ThreadPoolExecutor(2,4,1,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2),new CustomRejectHandler());
	     executer.allowCoreThreadTimeOut(true);
		for(int i=0;i<7;i++) {
			
			 String s=Integer.valueOf(i).toString();
			 
			executer.submit(() -> {
				
				try {
					Thread.sleep(5000);

				} catch (Exception e) {
					
					//handler exception here.

				}
				
				
				System.out.println("Task- " + s+" Processed by: " +Thread.currentThread().getName());
			});
		}
		executer.shutdown();
		
	}
	
	
	
	
	
}


class CustomThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread th=new Thread(r);
		
		th.setPriority(Thread.MIN_PRIORITY);
		th.setDaemon(false);
		
		
		
		return th;


	}
	
	

	
}


class CustomRejectHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

		System.out.println("Task Rejected: "+r.toString());
		
	}
	
}



















