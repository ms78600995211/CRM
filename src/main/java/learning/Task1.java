package learning;

import java.util.concurrent.Callable;

public class Task1 implements Callable<String> {
    private String name;

    public Task1(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Task " + name + " is running on thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task= " + name + " is completed on thread: " + Thread.currentThread().getName();     //result after completing given specific task 
    }
}
