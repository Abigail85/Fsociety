package com.co.lineadevida.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntityTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTransaction", nullable = false)
    private Long idTransaction;

    @Column(name = "concept", nullable = false)
    private String concept;

    @Column(name = "amount", nullable = false)
    private Float amount;

    @Column(name = "createdAtTransaction", nullable = false)
    private LocalDate createdAtTransaction = LocalDate.now();

    @Column(name = "updateAtTransaction", nullable = true)
    private Date updateAtTransaction;


    @ManyToOne  (optional = false)
    @JoinColumn(name = "idEnterprise",referencedColumnName = "idEnterprise")
    private EntityEnterprise idEnterprise;

}