package it.gabrieletondi.telldontaskkata.useCase;

import io.vavr.control.Either;
import it.gabrieletondi.telldontaskkata.domain.Order;
import it.gabrieletondi.telldontaskkata.repository.OrderRepository;

public class OrderApprovalUseCase {
    private final OrderRepository orderRepository;

    public OrderApprovalUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void run(OrderApprovalRequest request) {
        final Order order = orderRepository.getById(request.getOrderId());

        order.approve(request.isApproved());

        orderRepository.save(order);
    }

    public Either<String, Order> runNew(OrderApprovalRequest request) {
        return orderRepository.getById(request.getOrderId())
                .approve(request.isApproved())
                .flatMap(order -> {
                    orderRepository.save(order);
                    return Either.right(order);
                })
                .mapLeft(error -> error);
    }

}
