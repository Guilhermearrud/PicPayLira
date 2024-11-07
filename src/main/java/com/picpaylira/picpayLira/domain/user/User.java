package com.picpaylira.picpayLira.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name="users") //Since it will represent an entity in the DB
@Table(name="users") //Setting the name of the table for the entity
@Getter
@Setter
@AllArgsConstructor // So it will create all the constructor for the parameters of the class.
@EqualsAndHashCode(of="id") //Setting id as the primary key
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generating in incrementing
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String document;
    @Column(unique=true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;

}
