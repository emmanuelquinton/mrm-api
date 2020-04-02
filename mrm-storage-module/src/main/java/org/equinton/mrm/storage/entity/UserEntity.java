package org.equinton.mrm.storage.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;
    @Column
    private String serialNumber;
    @Column
    private String firstName;
    @Column
    private String lastName;
}
