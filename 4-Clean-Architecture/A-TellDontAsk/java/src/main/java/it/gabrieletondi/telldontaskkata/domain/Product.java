package it.gabrieletondi.telldontaskkata.domain;

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

    public BigDecimal getUnitaryTax() {
        return this.price
            .divide(BigDecimal.valueOf(100))
            .multiply(this.getCategory().getTaxPercentage())
            .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getUnitaryTaxedAmount() {
        return this.price
            .add(getUnitaryTax())
            .setScale(2, RoundingMode.HALF_UP);
    }
}
