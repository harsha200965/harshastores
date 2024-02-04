package com.ecommerce.harshastores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.harshastores.entity.Product;
import com.ecommerce.harshastores.request.ProductRequest;
import com.ecommerce.harshastores.service.ProductService;

/**
 * HarshastoresController containing all the APIs related to product.
 */
@RestController
@RequestMapping("/api/harshaStores")
public class HarshastoresController {

	@Autowired
	private ProductService productService;

	/**
	 * API operation to add single Product into the database.
	 * 
	 * @param product - Product
	 * @return Product
	 */
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody final Product product) {
		return productService.addProduct(product);
	}

	/**
	 * API operation to add multiple Products into the database.
	 * 
	 * @param products - List<Product>
	 * @return List<Product>
	 */
	@PostMapping("/addAllProducts")
	public List<Product> addallproducts(@RequestBody final List<Product> products) {
		return productService.addAllProduct(products);
	}

	/**
	 * API operation to delete Product from the database.
	 * 
	 * @param id - Long
	 * @return String
	 */
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable final Long id) {
		return productService.deleteProduct(id);
	}

	/**
	 * API operation to update Product details in the database.
	 * 
	 * @param product - ProductRequest
	 * @return Product
	 */
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody final ProductRequest product) {
		return productService.updateProduct(product);
	}

	/**
	 * API operation to fetch the Product details from the database using product
	 * id.
	 * 
	 * @param id - Long
	 * @return Product
	 */
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable final Long id) {
		return productService.getProduct(id);
	}

	/**
	 * API operation to fetch the Product details from the database using product
	 * name/description/variant name.
	 * 
	 * @param product - ProductRequest
	 * @return Product
	 */
	@PostMapping("/getProduct")
	public Product getProductByCondition(@RequestBody final ProductRequest product) {
		return productService.getProductByCondition(product);
	}
}
