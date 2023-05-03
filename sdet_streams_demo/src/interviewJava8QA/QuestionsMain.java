package interviewJava8QA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuestionsMain {

	private static int num = 0;
	
	public static void main(String[] args) {
//		streamDemo1();
//		flatMapDemo();
//			parallelStreams();
		
//	 WAP to print even and odd using to threads
		int limit = 10;
		for(int i = 0; i<limit; i++) {
			System.out.print(i+" ");
		}
		System.out.println("---------------------------------");
		Object obj = new Object();
		Thread t1 = new Thread(new PrintNumFunc(obj));
		Thread t2 = new Thread(new PrintNumFunc(obj));
		t1.start();
		t2.start();
		
	}

	public static void printNextInt(String name, Object object) {
		System.out.println(name+" "+ num+" ");
		num+=1;
		object.notify();
	}



	private static void parallelStreams() {
		//		------------parallel--------------------
				IntStream.rangeClosed(1, 10).forEach(num->System.out.println(Thread.currentThread().getName()+" "+num));;
				System.out.println("--------------------------------------------------");
				IntStream.rangeClosed(1, 10).parallel().forEach(num->System.out.println(Thread.currentThread().getName()+" "+num));;
	}




	private static void flatMapDemo() {
		List<User> users = Stream.of(
				new User("Petro", "063 333 66 99", Arrays.asList("asd@gmail.com", "qwe@gmail.com")),
				new User("Vasil", "063 444 66 22", Arrays.asList("jkklj@gmail.com", "ytui@gmail.com"))
				
				).collect(Collectors.toList());
		List<String> phones = users.stream()
			.map(User::getPhone)
			.collect(Collectors.toList());
		
		System.out.println(phones);
		
		//flat map is used for fields with collections
		//this is list of lists
		List<List<String>> emailsList = users.stream()
			.map(User::getEmail)
			.collect(Collectors.toList());
		System.out.println(emailsList);
		// we want one list of strings
		 List<String> emails = users.stream()
		 		.flatMap(u->u.getEmail().stream())
		 		.collect(Collectors.toList());
		System.out.println(emails);
	}

	


	private static void streamDemo1() {
		QuestionsMain instance = new QuestionsMain();
		
		List<Integer> list = Arrays.asList(4,7,23,12,78,10,33);
		list.stream()
			.filter(t-> t>14)
			.sorted()
//			.forEach(System.out::println);
//			.forEach(QuestionsMain::printElement); // static reference (method must be static)
			.forEach(instance::printElement); //reference on instance method (method must be not static)
	}

	
	
	private void printElement(int i) {
		System.out.println(i);
	}
	
	
}
