package rs.ac.uns.ftn.BookingBaboon.domain.users;

import jakarta.persistence.*;
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

    private String password;

    private UserStatus status = UserStatus.Inactive;

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

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
