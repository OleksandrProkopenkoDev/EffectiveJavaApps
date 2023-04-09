package com.spro.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spro.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

//	public Product findByName(String name);

	List<Product> findByName(String name);

	/*
	 * Returns an Optional which contains the found product entry by using its id as
	 * search criteria. If no product entry is found. this method returns an empty
	 * Optional
	 */
	Optional<Product> getByName(String name);

	boolean existsByName(String name);

	int countByName(String name);

	int deleteByName(String name);

	List<Product> findByPriceGreaterThan(BigDecimal price);

	/*
	 * Returns the found list of product entries whose title or description is given
	 * as a method parameter. If no product entries is found, this method returns an
	 * empty list
	 */
	List<Product> findByNameOrDescription(String name, String description);

	/*
	 * Returns the found list of product entries whose title and description is
	 * given as a method parameter. If no product entries is found, this method
	 * returns an empty list
	 */
	List<Product> findByNameAndDescription(String name, String description);

	List<Product> findDistinctByName(String name);// dont work((((

	List<Product> findByNameContaining(String name);

	List<Product> findByDescriptionContaining(String description);

	/*
	 * %-replaces line of any characters. _ - replaces one character, also can use
	 * [AB] - starts from A or B. Green%| - will search string 'Green%' (% as
	 * symbol, not wild card)
	 */ 
	List<Product> findByNameLike(String name);
	
	List<Product> findByPriceBetween(BigDecimal statrPrice, BigDecimal endPrice);
	
	List<Product> findByDateCreatedBetween(LocalDateTime startDate,LocalDateTime endDate);
	
	List<Product> findByNameIn(List<String> names);
}
