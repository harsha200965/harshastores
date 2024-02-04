package com.ecommerce.harshastores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.harshastores.entity.Product;

/**
 * ProductRepository which handles interaction with the database and fetch the
 * data.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	/**
	 * Database call to fetch Product details by product name.
	 * 
	 * @param name - String
	 * @return Product
	 */
	@Query(value = "SELECT * FROM product where name=:name", nativeQuery = true)
	public Product findByName(final String name);

	/**
	 * Database call to fetch Product details by product description.
	 * 
	 * @param description - String
	 * @return Product
	 */
	@Query(value = "SELECT * FROM product where description=:description", nativeQuery = true)
	public Product findByDescription(final String description);

	/**
	 * Database call to fetch Product details by variantName.
	 * 
	 * @param variantName - String
	 * @return Product
	 */
	@Query(value = "SELECT * FROM product p INNER JOIN product_variant pv ON p.id = pv.p_id where pv.name=:variantName", nativeQuery = true)
	public Product findByVariantName(final String variantName);
}