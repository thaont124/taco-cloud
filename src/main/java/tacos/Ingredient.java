package tacos;

import lombok.Data;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;
@Entity // đánh dấu Ingredient là một entity
@Table(name = "ingredient")// chỉ định tên bảng trong cơ sở dữ liệu
@Data // sử dụng Lombok để tự động tạo getter, setter, equals, hashCode
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true) // sử dụng Lombok để tạo constructor không tham số và private
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
