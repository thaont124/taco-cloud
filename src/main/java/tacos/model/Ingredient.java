package tacos.model;

import lombok.Data;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;
@Entity
@Data
public class Ingredient {

    @Id // chỉ định trường id làm khóa chính
    private String id;
    private String name;

    @Enumerated(EnumType.STRING) // chỉ định kiểu dữ liệu của trường type là Enum và lưu dưới dạng String
    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
