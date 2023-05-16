package it.gabrieletondi.telldontaskkata.domain;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import it.gabrieletondi.telldontaskkata.repository.ProductCatalog;
import it.gabrieletondi.telldontaskkata.useCase.SellItemRequest;
import it.gabrieletondi.telldontaskkata.useCase.UnknownProductException;

public class Order {
    private BigDecimal total;
    private String currency;
    private List<OrderItem> items;
    private BigDecimal tax;
    private OrderStatus status;
    private int id;

    public Order() {}

    public Order(OrderStatus status) {
        this.status = status;
        this.setItems(new ArrayList<>());
        this.setCurrency("EUR");
        this.setTotal(new BigDecimal("0.00"));
        this.setTax(new BigDecimal("0.00"));
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addItem(SellItemRequest itemRequest, ProductCatalog productCatalog) {
        Product product = productCatalog.getByName(itemRequest.getProductName());

        if (product == null) {
            throw new UnknownProductException();
        }

        OrderItem orderItem = new OrderItem(itemRequest.getQuantity(), product);
        getItems().add(orderItem);

        setTotal(getTotal().add(orderItem.getTaxedAmount()));
        setTax(getTax().add(orderItem.getTax()));
    }
}
