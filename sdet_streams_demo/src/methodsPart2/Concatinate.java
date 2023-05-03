package methodsPart2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concatinate {

	public static void main(String[] args) {

		List<String> animals =Arrays.asList("Dog","Cat","Elephant");
		List<String> birds =Arrays.asList("peackot","parrot","Crow");
		
		Stream<String> stream1 = animals.stream();
		Stream<String> stream2 = birds.stream();
		
		List<String> collect = Stream.concat(stream1, stream2)
									 .collect(Collectors.toList());
		for(String item:collect) {
			System.out.println(item);
		}
	
	}

}
