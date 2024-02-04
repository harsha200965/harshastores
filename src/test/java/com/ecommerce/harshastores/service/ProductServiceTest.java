package com.ecommerce.harshastores.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.harshastores.entity.Product;
import com.ecommerce.harshastores.entity.ProductVariant;
import com.ecommerce.harshastores.repository.ProductRepository;
import com.ecommerce.harshastores.request.ProductRequest;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService service;

	@Mock
	private ProductRepository productRepository;
	
	@Test
	void addProductTest() {
		Product requestData = new Product();
		requestData.setId(276387L);
		requestData.setName("shirt");
		requestData.setDescription("men's shirt");
		BigDecimal bigInteger = new BigDecimal("100.00");
		requestData.setPrice(bigInteger);
		List<ProductVariant> variants = new ArrayList<>();
		ProductVariant productVarient = new ProductVariant();
		productVarient.setId(876L);
		productVarient.setName("tshirt");
		productVarient.setSku("sku");
		productVarient.setStockCount(50);
		productVarient.setAdditionalCost(bigInteger);
		variants.add(productVarient);
		requestData.setVariants(variants);
		Mockito.when(productRepository.save(Mockito.any())).thenReturn(requestData);
		Product response = service.addProduct(requestData);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void addallproductsTest() {
		Product requestData = new Product();
		requestData.setId(276387L);
		requestData.setName("shirt");
		requestData.setDescription("men's shirt");
		BigDecimal bigInteger = new BigDecimal("100.00");
		requestData.setPrice(bigInteger);
		List<ProductVariant> variants = new ArrayList<>();
		ProductVariant productVarient = new ProductVariant();
		productVarient.setId(876L);
		productVarient.setName("tshirt");
		productVarient.setSku("sku");
		productVarient.setStockCount(50);
		productVarient.setAdditionalCost(bigInteger);
		variants.add(productVarient);
		requestData.setVariants(variants);
		List<Product> productsList = new ArrayList<>();
		productsList.add(requestData);
		Mockito.when(productRepository.saveAll(Mockito.any())).thenReturn(productsList);
		List<Product> response = service.addAllProduct(productsList);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void deleteProductTest() {
		Mockito.doNothing().when(productRepository).deleteById(Mockito.anyLong());
		String response = service.deleteProduct(276387L);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void updateProductTest() {
		Product requestData = new Product();
		ProductRequest requestData1 = new ProductRequest();
		BigDecimal bigInteger = new BigDecimal("100.00");
		requestData.setPrice(bigInteger);
		List<ProductVariant> variants = new ArrayList<>();
		ProductVariant productVarient = new ProductVariant();
		productVarient.setId(876L);
		productVarient.setName("tshirt");
		productVarient.setSku("sku");
		productVarient.setStockCount(50);
		productVarient.setAdditionalCost(bigInteger);
		requestData1.setId(276387L);
		requestData1.setAddVariants(true);
		requestData.setId(276387L);
		requestData.setName("shirt");
		requestData.setDescription("men's shirt");
		requestData1.setVariants(variants);
		variants.add(productVarient);
		requestData.setVariants(variants);
		Optional<Product> resp = Optional.ofNullable(new Product());
		Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(resp);
		Assertions.assertThrows(NullPointerException.class , () -> service.updateProduct(requestData1));
	}
	
	@Test
	void getProductTest() {
		Optional<Product> resp = Optional.ofNullable(new Product());
		Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(resp);
		Optional<Product> response = productRepository.findById(276387L);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void getProductByConditionTest() {
		ProductRequest requestData = new ProductRequest();
		requestData.setName("name");
		Product resp = new Product();
		Mockito.when(productRepository.findByName(Mockito.any())).thenReturn(resp);
		Product response = service.getProductByCondition(requestData);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void getProductByCondition1Test() {
		ProductRequest requestData1 = new ProductRequest();
		requestData1.setName("name");
		Product requestData = new Product();
		requestData.setId(276387L);
		requestData.setName("shirt");
		requestData.setDescription("men's shirt");
		BigDecimal bigInteger = new BigDecimal("100.00");
		requestData.setPrice(bigInteger);
		List<ProductVariant> variants = new ArrayList<>();
		ProductVariant productVarient = new ProductVariant();
		productVarient.setId(876L);
		productVarient.setName("tshirt");
		productVarient.setSku("sku");
		productVarient.setStockCount(50);
		productVarient.setAdditionalCost(bigInteger);
		variants.add(productVarient);
		requestData.setVariants(variants);
		Mockito.when(productRepository.findByName(Mockito.any())).thenReturn(requestData);
		Product response = service.getProductByCondition(requestData1);
		Assertions.assertNotNull(response);
		ProductRequest requestData2 = new ProductRequest();
		requestData2.setDescription("name");
		Mockito.when(productRepository.findByDescription(Mockito.any())).thenReturn(requestData);
		Product response2 = service.getProductByCondition(requestData2);
		Assertions.assertNotNull(response2);
		ProductRequest requestData3 = new ProductRequest();
		requestData3.setVariantName("name");
		Mockito.when(productRepository.findByVariantName(Mockito.any())).thenReturn(requestData);
		Product response3 = service.getProductByCondition(requestData3);
		Assertions.assertNotNull(response3);
	}
}
