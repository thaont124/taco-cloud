package tacos.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Taco_Ingredients implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int tacoId;

    @NotNull
    private String ingredientId;


}
