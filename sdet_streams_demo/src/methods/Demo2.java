package methods;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo2 {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//count
		long count = numbers.stream()
			   .filter(num->num%2==0)
			   .count();
		System.out.println("input : "+numbers);
		System.out.println("Count even numbers: "+count);	
		//min
		Optional<Integer> min = numbers.stream()
				.min((val1,val2)->{return val1.compareTo(val2);});
		System.out.println("min : "+min.get());
		//max
		Optional<Integer> max = numbers.stream()
				.max((val1,val2)-> val1.compareTo(val2));
		System.out.println("max : "+max.get());
	
		
		
	
	}

}
