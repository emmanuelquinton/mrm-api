package org.equinton.mrm.storage.entity;

import lombok.*;
import org.equinton.mrm.domain.model.User;
import org.equinton.mrm.storage.UserMapper;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "person")
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
    @Column
    private String serialNumber;
    @Column
    private String firstName;
    @Column
    private String lastName;

    public User toUser() {
        return UserMapper.INSTANCE.toDomainObject(this);
    }
}
