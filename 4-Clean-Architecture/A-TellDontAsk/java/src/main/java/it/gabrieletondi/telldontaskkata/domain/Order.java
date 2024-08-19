package it.gabrieletondi.telldontaskkata.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import it.gabrieletondi.telldontaskkata.service.ShipmentService;
import it.gabrieletondi.telldontaskkata.useCase.ApprovedOrderCannotBeRejectedException;
import it.gabrieletondi.telldontaskkata.useCase.OrderCannotBeShippedException;
import it.gabrieletondi.telldontaskkata.useCase.OrderCannotBeShippedTwiceException;
import it.gabrieletondi.telldontaskkata.useCase.RejectedOrderCannotBeApprovedException;
import it.gabrieletondi.telldontaskkata.useCase.ShippedOrdersCannotBeChangedException;

public class Order {
    
    private BigDecimal total = new BigDecimal("0.00");
    private String currency = "EUR";
    private List<OrderItem> items = new ArrayList<>();
    private BigDecimal tax = new BigDecimal("0.00");
    protected OrderStatus status = OrderStatus.CREATED;
    protected int id;

    public BigDecimal getTotal() {
        return total;
    }

    public String getCurrency() {
        return currency;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void addItem(OrderItem orderItem) {
        this.items.add(orderItem);

        this.total = this.total.add(orderItem.getTaxedAmount());
        this.tax = this.tax.add(orderItem.getTax());
    }

    public void approve(boolean approved) {
        if (this.getStatus().equals(OrderStatus.SHIPPED)) {
            throw new ShippedOrdersCannotBeChangedException();
        }

        if (approved && this.getStatus().equals(OrderStatus.REJECTED)) {
            throw new RejectedOrderCannotBeApprovedException();
        }

        if (!approved && this.getStatus().equals(OrderStatus.APPROVED)) {
            throw new ApprovedOrderCannotBeRejectedException();
        }

        this.status = (approved ? OrderStatus.APPROVED : OrderStatus.REJECTED);
    }

    public void ship(ShipmentService shipmentService) {
        
        if (this.getStatus().equals(OrderStatus.CREATED) || this.getStatus().equals(OrderStatus.REJECTED)) {
            throw new OrderCannotBeShippedException();
        }

        if (this.getStatus().equals(OrderStatus.SHIPPED)) {
            throw new OrderCannotBeShippedTwiceException();
        }

        shipmentService.ship(this);

        this.status = OrderStatus.SHIPPED;
    }
}
