package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo2 {

	public static void main(String[] args) {
		List<String> vehicles = Arrays.asList("bus","car","bicycle","flight","train");
//		find length of every element and push it to new collection
		List<Integer> lengths = new ArrayList<>();
		
		for(String name: vehicles) {
			lengths.add(name.length());
		}
		
		System.out.println("for each aproach");
		System.out.println(lengths);
		System.out.println();
		
		lengths = vehicles.stream()
				.map(item->item.length())
				.collect(Collectors.toList());

		System.out.println("map aproach");
		System.out.println(lengths);
		System.out.println();
		
		
		
	}

}
