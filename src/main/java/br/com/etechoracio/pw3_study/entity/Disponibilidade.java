package br.com.etechoracio.pw3_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_DISPONIBILIDADE")
public class Disponibilidade {
    @Id
    @Column(name = "ID_DISPONIBILIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_DIA_SEMANA")
    private String DiaSemana;

    @Column(name = "DT_DAS")
    private LocalDateTime DataDas;

    @Column(name = "DT_ATE")
    private LocalDateTime DataAte;
}
