package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class PersonMySQLAdapter extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String telefonNumber;
}

