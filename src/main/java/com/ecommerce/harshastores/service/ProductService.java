package com.ecommerce.harshastores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.harshastores.entity.Product;
import com.ecommerce.harshastores.repository.ProductRepository;
import com.ecommerce.harshastores.request.ProductRequest;

/**
 * ProductService - Service layer which handles all the operations related to
 * Product.
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Operation to add single Product into the database.
	 * 
	 * @param product - Product
	 * @return Product
	 */
	public Product addProduct(final Product product) {
		return productRepository.save(product);
	}

	/**
	 * Operation to add multiple Products into the database.
	 * 
	 * @param products - List<Product>
	 * @return List<Product>
	 */
	public List<Product> addAllProduct(final List<Product> products) {
		return productRepository.saveAll(products);
	}

	/**
	 * Operation to delete Product from the database.
	 * 
	 * @param id - Long
	 * @return String
	 */
	public String deleteProduct(final Long id) {
		productRepository.deleteById(id);
		return "Product Deleted" + id;
	}

	/**
	 * Operation to update Product details in the database.
	 * 
	 * @param product - ProductRequest
	 * @return Product
	 */
	public Product updateProduct(final ProductRequest product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDescription(product.getDescription());
		if (product.getAddVariants()) {
			existingProduct.getVariants().addAll(product.getVariants());
		}
		return productRepository.save(existingProduct);
	}

	/**
	 * Operation to fetch the Product details from the database using product id.
	 * 
	 * @param id - Long
	 * @return Product
	 */
	public Product getProduct(final Long id) {
		return productRepository.findById(id).orElse(null);
	}

	/**
	 * Operation to fetch the Product details from the database using product
	 * name/description/variant name.
	 * 
	 * @param product - ProductRequest
	 * @return Product
	 */
	public Product getProductByCondition(final ProductRequest product) {
		Product fetchedProduct = new Product();
		if (product.getName() != null) {
			fetchedProduct = productRepository.findByName(product.getName());
		} else if (product.getDescription() != null) {
			fetchedProduct = productRepository.findByDescription(product.getDescription());
		} else if (product.getVariantName() != null) {
			fetchedProduct = productRepository.findByVariantName(product.getVariantName());
		}
		return fetchedProduct;
	}
}