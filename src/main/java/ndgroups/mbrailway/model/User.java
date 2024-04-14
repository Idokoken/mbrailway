package ndgroups.mbrailway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotBlank(message = "name is required")
//    private String name;
    @Column(unique = true)
    @NotBlank(message = "email is required")
    private String email;
    private String username;
    @NotBlank(message = "password is required")
    private String password;
//    @Enumerated(EnumType.STRING)
    private String role;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public User(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
