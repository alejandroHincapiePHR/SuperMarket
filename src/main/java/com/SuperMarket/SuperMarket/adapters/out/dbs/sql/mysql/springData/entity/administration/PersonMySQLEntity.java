package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "person")
public class PersonMySQLEntity extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "telefonnumber")
    private String telefonNumber;
}

