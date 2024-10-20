package ie.atu.week5.customerapp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    @NotNull(message = "Order code is required.")
    private int orderCode;

    @NotBlank(message = "Order details are required.")
    private String orderDetails;

    @NotBlank(message = "Order date is required.")
    private String orderDate;

    @NotBlank(message = "Customer ID is required.")
    private String customerId; // Reference to the associated customer
}
