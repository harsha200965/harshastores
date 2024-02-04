package com.ecommerce.harshastores.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.harshastores.entity.Product;
import com.ecommerce.harshastores.entity.ProductVariant;
import com.ecommerce.harshastores.request.ProductRequest;
import com.ecommerce.harshastores.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class HarshastoresControllerTest {

	@InjectMocks
	private HarshastoresController controller;

	@Mock
	private ProductService productService;

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
		Mockito.when(productService.addProduct(Mockito.any())).thenReturn(requestData);
		Product response = controller.addProduct(requestData);
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
		Mockito.when(productService.addAllProduct(Mockito.any())).thenReturn(productsList);
		List<Product> response = controller.addallproducts(productsList);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void deleteProductTest() {
		Mockito.when(productService.deleteProduct(Mockito.anyLong())).thenReturn(Mockito.anyString());
		String response = controller.deleteProduct(276387L);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void updateProductTest() {
		ProductRequest requestData1 = new ProductRequest();
		requestData1.setId(276387L);
		requestData1.setAddVariants(true);
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
		Mockito.when(productService.updateProduct(Mockito.any())).thenReturn(requestData);
		Product response = controller.updateProduct(requestData1);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void getProductTest() {
		Product productResponse = new Product();
		productResponse.setId(276387L);
		productResponse.setName("shirt");
		productResponse.setDescription("men's shirt");
		BigDecimal bigInteger = new BigDecimal("100.00");
		productResponse.setPrice(bigInteger);
		List<ProductVariant> variants = new ArrayList<>();
		ProductVariant productVarient = new ProductVariant();
		productVarient.setId(876L);
		productVarient.setName("tshirt");
		productVarient.setSku("sku");
		productVarient.setStockCount(50);
		productVarient.setAdditionalCost(bigInteger);
		variants.add(productVarient);
		productResponse.setVariants(variants);
		Mockito.when(productService.getProduct(Mockito.anyLong())).thenReturn(productResponse);
		Product response = controller.getProduct(276387L);
		Assertions.assertNotNull(response);
	}

	@Test
	void getProductByConditionTest() {
		ProductRequest requestData1 = new ProductRequest();
		requestData1.setId(276387L);
		requestData1.setAddVariants(true);
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
		Mockito.when(productService.getProductByCondition(Mockito.any())).thenReturn(requestData);
		Product response = controller.getProductByCondition(requestData1);
		Assertions.assertNotNull(response);
	}
}
