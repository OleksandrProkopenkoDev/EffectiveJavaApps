package interviewJava8QA;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrinter {

	private static Object obj = new Object();
	private static IntPredicate evenCondition = e->e%2 == 0;
	private static IntPredicate oddCondition = e->e%2 != 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		CompletableFuture.runAsync(()->EvenOddPrinter.printNumber(oddCondition));
		CompletableFuture.runAsync(()->EvenOddPrinter.printNumber(evenCondition));
		Thread.sleep(1000);
	}
	
	public static void printNumber(IntPredicate condition) {
		IntStream.rangeClosed(1, 10).filter(condition).forEach(EvenOddPrinter::execute);
	}
	
	public static void execute(int num) {
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName()+" : " +num);
			obj.notify();
			try {
				obj.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
