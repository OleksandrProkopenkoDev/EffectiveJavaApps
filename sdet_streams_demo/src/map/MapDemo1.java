package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo1 {

	public static void main(String[] args) {
		
		List<String> vehicles = Arrays.asList("bus","car","bicycle","flight","train");
		
//		need to convert elements to Uppercase
		
		List<String> vehiclesUppercase = new ArrayList<>();
		for(String name: vehicles) {
			vehiclesUppercase.add( name.toUpperCase());
			
		}
		System.out.println("for each aproach");
		System.out.println(vehiclesUppercase);
		System.out.println();
		
//		using streams map
		vehiclesUppercase = vehicles.stream()
			.map(name->name.toUpperCase())
			.collect(Collectors.toList());

		System.out.println("stream map aproach");
		System.out.println(vehiclesUppercase);
		System.out.println();
		
		
		
		
		
		
		
	}

}
