package com.ecommerce.harshastores.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product Variant entity class
 */
@Entity
@Table(name = "ProductVariant")
public class ProductVariant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "variant_id")
	private Long id;
	private String name;
	private String sku;
	private BigDecimal additionalCost;
	private Integer stockCount;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(final String sku) {
		this.sku = sku;
	}

	public BigDecimal getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalCost(final BigDecimal additionalCost) {
		this.additionalCost = additionalCost;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(final Integer stockCount) {
		this.stockCount = stockCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalCost, id, name, sku, stockCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductVariant other = (ProductVariant) obj;
		return Objects.equals(additionalCost, other.additionalCost) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(sku, other.sku)
				&& Objects.equals(stockCount, other.stockCount);
	}

	@Override
	public String toString() {
		return "ProductVariant [id=" + id + ", name=" + name + ", sku=" + sku + ", additionalCost=" + additionalCost
				+ ", stockCount=" + stockCount + "]";
	}
}