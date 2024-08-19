package it.gabrieletondi.telldontaskkata.domain;

public class OrderActionResult {
    private final Order order;
    private final String failureMessage;

    public Boolean orderActionHasFailed() {
        return !failureMessage.isEmpty();
    }

    public OrderActionResult(Order order) {
        this(order, null);
    }

    public OrderActionResult(Order order, String failureMessage) {
        this.order = order;
        this.failureMessage = failureMessage;
    }

    public static OrderActionResult allGood(Order order) {
        return new OrderActionResult(order);
    }

    public static OrderActionResult failure(String failureMessage) {
        return new OrderActionResult(null, failureMessage);
    }
}
