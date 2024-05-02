package com.riwi.vacants.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40,nullable = false)
    private String name;
    private  String location;
    @Column(length = 14,nullable = false)
    private String contact;

    // @OneToMany --- uno a muchos: Una empresa puede tener muchas vacantes
    //mapedBy: Especificamos donde se guardará la información de la relación
    //fetch EAGER:Join Implícito | fetch LAZY: Join perezoso
    //orphanRemoval TRUE -> Remover objeto huérfano (Sin llave foránea)
    @OneToMany(mappedBy = "companies",cascade = CascadeType.ALL,orphanRemoval = false,fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vacant> vacants;
}
