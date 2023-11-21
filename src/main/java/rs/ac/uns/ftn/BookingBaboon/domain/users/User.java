package rs.ac.uns.ftn.BookingBaboon.domain.users;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@TableGenerator(name="user_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="user", valueColumnName="value_pk")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id_generator")
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private boolean isBlocked;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;


}
