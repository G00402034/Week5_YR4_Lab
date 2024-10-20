package ie.atu.week5.customerapp;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    @NotBlank(message = "Name is required.")
    private String name;
    @NotBlank(message = "Email is required.")
    private String email;
}