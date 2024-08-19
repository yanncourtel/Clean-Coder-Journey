package it.gabrieletondi.telldontaskkata.useCase;

import it.gabrieletondi.telldontaskkata.domain.Order;
import it.gabrieletondi.telldontaskkata.domain.OrderStatus;
import it.gabrieletondi.telldontaskkata.doubles.TestOrderRepository;

import static it.gabrieletondi.telldontaskkata.domain.OrderStatus.APPROVED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderApprovalUseCaseTest {
    private final TestOrderRepository orderRepository = new TestOrderRepository();
    private final OrderApprovalUseCase useCase = new OrderApprovalUseCase(orderRepository);

    @Test
    public void approvedExistingOrder() {
        Order initialOrder = TestOrder.newOrder(1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest();
        request.setOrderId(1);
        request.setApproved(true);

        useCase.run(request);

        final Order savedOrder = orderRepository.getSavedOrder();
        assertThat(savedOrder.getStatus()).isEqualTo(APPROVED);
    }

    @Test
    public void rejectedExistingOrder() {
        Order initialOrder = TestOrder.newOrder(1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest();
        request.setOrderId(1);
        request.setApproved(false);

        useCase.run(request);

        final Order savedOrder = orderRepository.getSavedOrder();
        assertThat(savedOrder.getStatus()).isEqualTo(OrderStatus.REJECTED);
    }

    @Test
    public void approvedExistingOrderNoException() {
        Order initialOrder = TestOrder.newOrder(1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest();
        request.setOrderId(1);
        request.setApproved(true);

        useCase.runNew(request)
                .peek(result -> assertThat(result.getStatus()).isEqualTo(APPROVED))
                .peekLeft(error -> Assertions.fail("Should not fail"));
    }

    @Test
    public void cannotApproveRejectedOrderNoException() {
        Order initialOrder = TestOrder.rejectedOrder(1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest();
        request.setOrderId(1);
        request.setApproved(true);

        useCase.runNew(request)
                .peek(result -> Assertions.fail("Should not succeed"))
                .peekLeft(error -> assertThat(error).isEqualTo("cannotApproveRejectedOrder"));
    }

    @Test
    public void shippedOrdersCannotBeApprovedNoException() {
        Order initialOrder = TestOrder.shippedOrder(1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest();
        request.setOrderId(1);
        request.setApproved(true);

        useCase.runNew(request)
                .peek(result -> Assertions.fail("Should not succeed"))
                .peekLeft(error -> assertThat(error).isEqualTo("ShippedOrdersCannotBeChanged"));
    }

    @Test
    public void shippedOrdersCannotBeRejectedNoException() {
        Order initialOrder = TestOrder.shippedOrder(1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest();
        request.setOrderId(1);
        request.setApproved(false);

        useCase.runNew(request)
                .peek(result -> Assertions.fail("Should not succeed"))
                .peekLeft(error -> assertThat(error).isEqualTo("ShippedOrdersCannotBeChanged"));
    }
}
