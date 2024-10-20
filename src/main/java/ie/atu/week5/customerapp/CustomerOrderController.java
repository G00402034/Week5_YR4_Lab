package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerOrderController {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerOrderController(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/customer-with-orders")
    public ResponseEntity<String> createCustomerWithOrders(@RequestBody CustomerOrderRequest customerOrderRequest) {
        // 1. Save the Customer and get the generated customer ID
        Customer savedCustomer = customerRepository.save(customerOrderRequest.getCustomer());

        // 2. Save the Orders and link them to the customer
        List<Order> orders = customerOrderRequest.getOrders();
        for (Order order : orders) {
            order.setCustomerId(savedCustomer.getId()); // Link the order to the saved customer
            orderRepository.save(order); // Save each order individually
        }

        return ResponseEntity.ok("Customer and orders created successfully");
    }
}
