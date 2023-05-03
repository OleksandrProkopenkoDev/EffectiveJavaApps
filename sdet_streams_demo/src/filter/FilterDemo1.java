package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo1 {

	public static void main(String[] args) {
		/*
		 * ArrayList<Integer> numbersList = new ArrayList<>(); numbersList.add(10);
		 * numbersList.add(15); numbersList.add(20); numbersList.add(25);
		 * numbersList.add(30); numbersList.add(35);
		 */
		List<Integer> numbersList = Arrays.asList(10,15,20,25,30,35);
//		need filter by some condition
		List<Integer> evenNumbersList = new ArrayList<>();
		
//		without streams
		for(int n: numbersList) {
			if(n%2==0)evenNumbersList.add(n);
		}
		System.out.println("Even numbers without streams");
		System.out.println(evenNumbersList);
		
//		using streams
		
		evenNumbersList = numbersList.stream()
			.filter(n->n%2==0)
			.collect(Collectors.toList());
		System.out.println("Even numbers with streams");
		System.out.println(evenNumbersList);
//		without passing data to new collection:
		numbersList.stream()
		.filter(n->n%2==0)
		.forEach(n->System.out.println(n));
		
//		other variant of syntax
		numbersList.stream()
		.filter(n->n%2==0)
		.forEach(System.out::println);
	}

}
