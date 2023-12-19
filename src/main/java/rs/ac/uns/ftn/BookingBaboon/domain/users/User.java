package rs.ac.uns.ftn.BookingBaboon.domain.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@TableGenerator(name="user_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="user", initialValue=10, valueColumnName="value_pk")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id_generator")
    private Long id;

    @NotNull
    private String password;

    @Enumerated
    private UserStatus status = UserStatus.Inactive;

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    @Enumerated
    private Role role = Role.GUEST;

    @Transient
    private String jwt;

    public void activate() {
        this.status = UserStatus.Active;
    }

    public boolean isActive() {
        return this.status == UserStatus.Active;
    }
}
