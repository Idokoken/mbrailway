package ndgroups.mbrailway.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
public class PersonForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "name is required")
//    @Size(min=2, max=30)
    private String name;

    @NotNull(message = "age is required")
    @Min(18)
    private Integer age;

    @Override
    public String toString() {
        return "ContactForm{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
