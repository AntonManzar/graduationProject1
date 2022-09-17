package graduationProject.services;

import graduationProject.models.Order;
import graduationProject.models.Person;
import graduationProject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> showListOrders(Person person) {
        return orderRepository.findAllByOrderOwner(person);
    }
}
