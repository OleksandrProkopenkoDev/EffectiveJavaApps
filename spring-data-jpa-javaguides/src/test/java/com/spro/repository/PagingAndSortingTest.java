package com.spro.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spro.entity.Product;

@SpringBootTest
public class PagingAndSortingTest {

	@Autowired
	private ProductRepository productRepo;
	
//	@Test
	void findAllWithPaging() {
		int pageNumber = 2;
		int pageSize = 6;
//		create pagable object
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
//		findAll method and pass pageable instance
		 Page<Product> page = productRepo.findAll(pageable);// for every next page need new request
		List<Product> results = page.getContent();
		System.out.println("find all with pages. Page size = "+pageSize+
				", current page: "+pageNumber);
		results.forEach(item->{System.out.println(item);});
		
		
		System.out.println("Total pages: "+page.getTotalPages());
		System.out.println("Total elements: "+page.getTotalElements());
		System.out.println("Number of elements: "+page.getNumberOfElements());
		System.out.println("Page size: "+page.getSize());
		System.out.println("Page isLast?: "+page.isLast());
		System.out.println("Page isFirst?: "+page.isFirst());
	}
	
//	@Test
	void findAllWithSort() {
		String sortBy = "price";
		String sortDir = "asc";
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortBy).ascending()
				:
				Sort.by(sortBy).descending();	
		List<Product> results = productRepo.findAll(sort);
		System.out.println("find all with sorting. Sort by : "+sortBy+
				", sort direction: "+sortDir);
		results.forEach(item->{System.out.println(item);});
	}
	
//	@Test
	void sortingByMultipleFields() {
		String sortByName = "name";
		String sortByDescription = "description";
		String sortByPrice = "price";
		String sortDirection = "desc";
		
		Sort sortParam1 = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortByName).ascending()
				:
				Sort.by(sortByName).descending();
		
		Sort sortParam2 = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortByDescription).ascending()
				:
				Sort.by(sortByDescription).descending();
		
		Sort sortParam3 = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortByPrice).ascending()
				:
				Sort.by(sortByPrice).descending();
		
		Sort multiSort = sortParam3.and(sortParam2);
		
		List<Product> results = productRepo.findAll(multiSort);
		System.out.println("find all with multi sorting. Sort by : "+sortParam3+
				" and "+sortParam2+", sort direction: "+sortDirection);
		results.forEach(item->{System.out.println(item);});
		
	}
	
	@Test
	void pagingAndSorting() {
		String sortParam = "price";
		String sortDirection = "asc";
		
		int pageNo = 0;
		int pageSize = 6;
		
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortParam).ascending() : Sort.by(sortParam).descending();
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		Page<Product> page = productRepo.findAll(pageable);
		
		List<Product> results = page.getContent();
		System.out.println("find all with pages. Page size = "+pageSize+
				", current page: "+pageNo +" and sorted by "+sortParam);
		results.forEach(item->{System.out.println(item);});
		
		
		System.out.println("Total pages: "+page.getTotalPages());
		System.out.println("Total elements: "+page.getTotalElements());
		System.out.println("Number of elements: "+page.getNumberOfElements());
		System.out.println("Page size: "+page.getSize());
		System.out.println("Page isLast?: "+page.isLast());
		System.out.println("Page isFirst?: "+page.isFirst());
	}
	
}
