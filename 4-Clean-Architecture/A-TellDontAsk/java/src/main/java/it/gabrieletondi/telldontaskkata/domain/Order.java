package it.gabrieletondi.telldontaskkata.domain;

import it.gabrieletondi.telldontaskkata.useCase.ApprovedOrderCannotBeRejectedException;
import it.gabrieletondi.telldontaskkata.useCase.RejectedOrderCannotBeApprovedException;
import it.gabrieletondi.telldontaskkata.useCase.ShippedOrdersCannotBeChangedException;
import it.gabrieletondi.telldontaskkata.useCase.UnknownProductException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private BigDecimal total = new BigDecimal("0.00");
    private String currency;
    private List<OrderItem> items = new ArrayList<>();
    private BigDecimal tax = new BigDecimal("0.00");
    private OrderStatus status;
    private int id;

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

    public void approve(boolean isApproved) {
        this.validate(isApproved);
        this.changeStatus(isApproved);
    }

    private void changeStatus(boolean approved) {
        this.status = (approved ? OrderStatus.APPROVED : OrderStatus.REJECTED);
    }

    private void validate(boolean isApproved) {
        if (this.status.equals(OrderStatus.SHIPPED)) {
            throw new ShippedOrdersCannotBeChangedException();
        }

        if (isApproved && this.status.equals(OrderStatus.REJECTED)) {
            throw new RejectedOrderCannotBeApprovedException();
        }

        if (!isApproved && this.status.equals(OrderStatus.APPROVED)) {
            throw new ApprovedOrderCannotBeRejectedException();
        }
    }

    public static Order newOrder() {
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setCurrency("EUR");
        return order;
    }

    public void addItem(Product product, int quantity) {

        if (product == null) {
            throw new UnknownProductException();
        }

        var orderItem = new OrderItem(product, quantity);

        this.items.add(orderItem);
        this.setTotal(this.getTotal().add(orderItem.getTaxedAmount()));
        this.setTax(this.getTax().add(orderItem.getTax()));
    }
}
