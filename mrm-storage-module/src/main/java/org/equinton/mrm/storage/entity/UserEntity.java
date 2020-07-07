package org.equinton.mrm.storage.entity;

import lombok.*;
import org.equinton.mrm.domain.model.User;
import org.equinton.mrm.storage.UserMapper;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "person", schema = "mrm")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserEntity  {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, updatable = false)


    private UUID id;
    @Column(name = "serial_number" )
    private String serialNumber;
    @Column(name = "first_name" )
    private String firstName;
    @Column(name = "last_name" )
    private String lastName;

    public User toUser() {
        return UserMapper.INSTANCE.toDomainObject(this);
    }
}
