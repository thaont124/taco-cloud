package tacos;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
@Table(name = "taco")
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //thết lập mã tự động tăng
    private Long id;
    private Date createdAt;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @ManyToMany(targetEntity=Ingredient.class) //thiết lập mqh n-n với bảng Ingredient
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;

    @PrePersist //thiết lập giá trị cho trường createdAt trước khi lưu thông tin của đối tượng
    void createdAt() {
        this.createdAt = new Date();
    }

}
