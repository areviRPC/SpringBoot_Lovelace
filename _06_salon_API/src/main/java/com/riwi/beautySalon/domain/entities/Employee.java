package com.riwi.beautySalon.domain.entities;

import java.util.List;

import com.riwi.beautySalon.utils.enums.RoleEmployee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 3
@Entity (name = "employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100 , nullable = false )
    private String firstName;
    @Column(length = 100 , nullable = false )
    private String LastName;
    @Column(length = 100)
    private String email;
    @Column(length = 20)
    private String phone;
    @Column(nullable = false , length = 50)
    @Enumerated(EnumType.STRING)
    private RoleEmployee role;

    // 7
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER,
        mappedBy = "employee",
        orphanRemoval = false
    )
    private List<Appointment> appointments;
}
