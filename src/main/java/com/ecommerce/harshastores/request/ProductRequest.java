package com.ecommerce.harshastores.request;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.ecommerce.harshastores.entity.ProductVariant;

public class ProductRequest {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private List<ProductVariant> variants;
	private Boolean addVariants;
	private String variantName;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public List<ProductVariant> getVariants() {
		return variants;
	}

	public void setVariants(final List<ProductVariant> variants) {
		this.variants = variants;
	}

	public Boolean getAddVariants() {
		return addVariants;
	}

	public void setAddVariants(final Boolean addVariants) {
		this.addVariants = addVariants;
	}

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(final String variantName) {
		this.variantName = variantName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addVariants, description, id, name, price, variantName, variants);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductRequest other = (ProductRequest) obj;
		return Objects.equals(addVariants, other.addVariants) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(variantName, other.variantName)
				&& Objects.equals(variants, other.variants);
	}

	@Override
	public String toString() {
		return "ProductRequest [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", variants=" + variants + ", addVariants=" + addVariants + ", variantName=" + variantName + "]";
	}

}