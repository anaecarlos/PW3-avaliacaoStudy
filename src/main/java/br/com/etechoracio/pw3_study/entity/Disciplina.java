package br.com.etechoracio.pw3_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_DISCIPLINA")
public class Disciplina {
    @Id
    @Column(name = "ID_DISCIPLINA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

}
