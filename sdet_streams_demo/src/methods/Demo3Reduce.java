package methods;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo3Reduce {

	public static void main(String[] args) {
		// reduce will combine all object in one
		List<String> strings = Arrays.asList("A","B","C","1","2","3");
		Optional<String> reduce = strings.stream()
				.reduce( (value,combinedValue)-> combinedValue+value); //A+B
		System.out.println("reduced : "+reduce.get());
		
		
		
	}

}
