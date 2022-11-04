package com.crud.primeirocrud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = -5787967548946411186L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Double income;


    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant birthDate;
    private Integer children;

}
