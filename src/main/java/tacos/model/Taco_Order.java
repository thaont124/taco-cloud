package tacos.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "taco_order_tacos")
public class Taco_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "order_id")
    private Long orderId;

    @NotNull
    private int tacoId;
}
