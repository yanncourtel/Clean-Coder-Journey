package it.gabrieletondi.telldontaskkata.domain;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal price;
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getComputedTax() {
        return this.price.divide(BigDecimal.valueOf(100))
            .multiply(this.category.getTaxPercentage())
            .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getComputedTaxedAmount() {
        return this.price.add(this.getComputedTax())
            .setScale(2, RoundingMode.HALF_UP);
    }

	public BigDecimal getTaxedAmount(int quantity) {
        return getComputedTaxedAmount()
            .multiply(BigDecimal.valueOf(quantity))
            .setScale(2, HALF_UP);
	}

    public BigDecimal getTaxAmount(int quantity) {
        return getComputedTax()
            .multiply(BigDecimal.valueOf(quantity));
    }
}
