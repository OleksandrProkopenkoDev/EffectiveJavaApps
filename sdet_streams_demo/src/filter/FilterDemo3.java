package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo3 {

	public static void main(String[] args) {
//		filter nulls from the collection
		
		List<String> words = Arrays.asList("cup", null, "forest", "sky", null, "theatre");
		
		List<String> result = 
		
		words.stream()
			.filter(str-> str!=null)
			.collect(Collectors.toList());
		System.out.println(result);
	}

}
