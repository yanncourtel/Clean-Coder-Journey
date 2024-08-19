package it.gabrieletondi.telldontaskkata.useCase;

import it.gabrieletondi.telldontaskkata.domain.Order;
import it.gabrieletondi.telldontaskkata.domain.OrderStatus;

public class TestOrder extends Order {

    public TestOrder(int id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }

    public static TestOrder newOrder(int id) {
        return new TestOrder(id, OrderStatus.CREATED);
    }

    public static TestOrder shippedOrder(int id) {
        return new TestOrder(id, OrderStatus.SHIPPED);
    }

    public static TestOrder approvedOrder(int id) {
        return new TestOrder(id, OrderStatus.APPROVED);
    }

    public static TestOrder rejectedOrder(int id) {
        return new TestOrder(id, OrderStatus.REJECTED);
    }
}
