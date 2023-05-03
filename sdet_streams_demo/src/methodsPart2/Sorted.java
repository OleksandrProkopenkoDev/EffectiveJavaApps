package methodsPart2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorted {

	public static void main(String[] args) {

		List<Integer> list1=Arrays.asList(2,4,1,7,5,9);
		List<Integer> sorted = list1.stream()
			 .sorted()//ascending order
			 .collect(Collectors.toList());
		System.out.println("input : "+list1);
		System.out.println("sorted: "+sorted);
	
		List<Integer> reverseSort = list1.stream()
		 .sorted(Comparator.reverseOrder())//descending order
		 .collect(Collectors.toList());
		System.out.println("revers: "+reverseSort);
		
		//strings
		List<String> list2 = Arrays.asList("John", "Mary", "Kevin", "David", "Smith");
		List<String> sortedStrings = list2.stream()
			.sorted()
			.collect(Collectors.toList());
			
		System.out.println("input strings  : "+list2);
		System.out.println("sorted strings : "+sortedStrings);
		
		List<String> sortedStringsReverse = list2.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("sorted reverse : "+sortedStringsReverse);
				
		
	}

}
