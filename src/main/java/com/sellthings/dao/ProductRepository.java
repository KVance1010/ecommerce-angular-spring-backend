package com.sellthings.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.sellthings.model.Product;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
	

	// JPQL findBy varibleName ... SELECT * FROM product WHERE category_id = ?
	Page<Product> findByCategoryId(@RequestParam("id")  Long id, Pageable pageable);
	
	// JPQL for SELECT * FROM product p WHERE p.name LIKE CONCAT('%', :name , '%')
	Page<Product> findByNameContaining(@RequestParam("name") String name,Pageable pageable);
}
