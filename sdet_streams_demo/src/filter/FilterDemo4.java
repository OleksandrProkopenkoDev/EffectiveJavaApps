package filter;

import java.util.ArrayList;
import java.util.List;

class Product{
	int id;
	String name;
	double price;

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	
}

public class FilterDemo4 {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "tea", 1.25));
		products.add(new Product(2, "book", 2.25));
		products.add(new Product(3, "laptop", 3.99));
		products.add(new Product(4, "note", 0.45));
		products.add(new Product(5, "coffee", 21.55));
		products.add(new Product(6, "grey", 12.25));
		products.add(new Product(7, "apple", 5.25));
		products.add(new Product(8, "potato", 7.25));
//		filter by price	
	
		products.stream()
			.filter(p->p.price>5)
			.forEach(prod->System.out.println(prod.price));
		
	}


	
	
	
	
}
