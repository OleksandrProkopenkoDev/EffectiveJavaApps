package methods;

import java.util.Arrays;
import java.util.List;

public class Demo4 {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("A","B","C","1","2","3");
		Object[] array = strings.stream().toArray();
		System.out.println(array.length);
		for(Object v : array) {
			System.out.println(v);
		}
	
	}

}
