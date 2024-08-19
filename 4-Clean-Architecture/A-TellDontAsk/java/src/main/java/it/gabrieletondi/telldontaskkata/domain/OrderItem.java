package it.gabrieletondi.telldontaskkata.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import it.gabrieletondi.telldontaskkata.useCase.UnknownProductException;

public class OrderItem {
    private Product product;
    private int quantity;
    private BigDecimal taxedAmount;
    private BigDecimal tax;

    public OrderItem(Product product, int quantity) {
        if (product == null) {
            throw new UnknownProductException();
        }

        this.product = product;
        this.quantity = quantity;

        BigDecimal unitaryTax = product.getPrice().divide(BigDecimal.valueOf(100)).multiply(product.getCategory().getTaxPercentage()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal unitaryTaxedAmount = product.getPrice().add(unitaryTax).setScale(2, RoundingMode.HALF_UP);

        this.taxedAmount = unitaryTaxedAmount.multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
        this.tax = unitaryTax.multiply(BigDecimal.valueOf(quantity));
    }

    public Product getProduct() {
        return product;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTaxedAmount() {
        return taxedAmount;
    }

    public BigDecimal getTax() {
        return tax;
    }
}
