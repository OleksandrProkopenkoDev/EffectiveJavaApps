package methodsPart2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAny {
	
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("one","two","three","one");
		
		Optional<String> findAny = strings.stream()
				.findAny();
		System.out.println("input   : "+strings);
		System.out.println("findAny : "+findAny.get());
		
		//find first
		Optional<String> findFirst = strings.stream()
				.findFirst();
		System.out.println("findFirst : "+findFirst.get());
		
	
	}
	
}
