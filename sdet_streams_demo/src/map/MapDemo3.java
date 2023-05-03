package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo3 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(2,3,4,5,6,7,8,9);
//		multiply by 3 and store in another collection
		List<Integer> results = new ArrayList<>();
		
		for(Integer i: numbers) {
			results.add(i*3);
		}
			

			System.out.println("for each aproach");
			System.out.println(results);
			System.out.println();
			
			results = numbers.stream()
						.map(num->num*3)
						.collect(Collectors.toList());

			System.out.println("map aproach");
			System.out.println(results);
			System.out.println();

		
	}

}
