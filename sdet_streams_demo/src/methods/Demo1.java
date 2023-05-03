package methods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Non terminal / processing methods
//distinct()
//limit()


//terminal method
//count()
public class Demo1 {

	public static void main(String[] args) {
		//distinct -> unique objects
		List<String> vehicles = Arrays.asList("bus","car","bicycle","bus","car","bike");
		List<String> distinctVehicles = vehicles.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println(distinctVehicles);//[bus, car, bicycle, bike]
	
				vehicles.stream()
				.distinct()
				.forEach(value->System.out.println(value));
				
		//count how many distinct vehicles
			long count=	vehicles.stream()
				.distinct()
				.count();
		System.out.println("count = "+count);
		
		//limit
		List<String> limit3 = vehicles.stream()
		.limit(3)
		.collect(Collectors.toList());
		System.out.println(limit3);
		
		
		
	}

}
