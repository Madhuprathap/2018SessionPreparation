package com.madhu.threads;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EService {
	
	//  ForkJoinPool, ScheduledThreadPoolExecutor, ThreadPoolExecutor are implementations of ExecutorService

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new Callable(){
		    public Object call() throws Exception {
		        System.out.println("Asynchronous Callable");
		        return "Callable Result";
		    }
		});

		try {
			System.out.println("future.get() = " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		    	System.out.println("1");
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		    	System.out.println("2");
		    	throw new Exception("Manul interupted");
//		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		    	System.out.println("3");
		        return "Task 3";
		    }
		});

		String result = null;
		try {
			result = executorService.invokeAny(callables);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("result = " + result);

		executorService.shutdown();
		int[] array = Arrays.stream(new int[10]).map(n -> 1).toArray();
		System.out.println(array[4]);
	}

	// invokeAny() -> Invoking this method does not return a Future, but returns the result of one of the Callable objects. You have no guarantee about which of the Callable's results you get. Just one of the ones that finish.
					//If one of the tasks complete (or throws an exception), the rest of the Callable's are cancelled.
	// invokeAll() -> executes all the methods and returns  all of the results of  Callable executions as future object
					// Keep in mind that a task might finish due to an exception, so it may not have "succeeded". There is no way on a Future to tell the difference.

	// future.cancel(); -> Canceling the task is only possible if the task has not yet started executing
	
	// If your application is started via a main() method and your main thread exits your application, the application will keep running if you have an active ExexutorService in your application. The active threads inside this ExecutorService prevents the JVM from shutting down.
	// executorService.shutdown(); -> will no longer accept new tasks, and once all threads have finished current tasks, the ExecutorService shuts down. All tasks submitted to the ExecutorService before shutdown() is called, are executed
	// executorService.shutdownNow();-> This will attempt to stop all executing tasks right away, and skips all submitted but non-processed tasks. There are no guarantees given about the executing tasks.
	// executorService.awaitTermination(); -> will block the thread calling it until either the ExecutorService has shutdown completely, or until a given time out occurs

	
}
