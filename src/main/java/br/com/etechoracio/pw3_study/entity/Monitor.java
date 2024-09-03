package br.com.etechoracio.pw3_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_MONITOR")
public class Monitor {
    @Id
    @Column(name = "ID_MONITOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_FOTO")
    private String foto;

    @Column(name = "TX_WHATSAPP")
    private String whatsapp;

    @Column(name = "TX_EMAIL")
    private String email;

    @Column(name = "TX_CONTEUDO")
    private String conteudo;

    @ManyToOne
    @Column(name = "ID_DISCIPLINA")
    @JoinColumn(name = "IdDisciplina", referencedColumnName="ID_DISCIPLINA")
    private Long idDisciplina;

    @ManyToMany
    @JoinTable(name ="TBL_REL_MONITOR_DISPONIBILIDADE",
            joinColumns = @JoinColumn(name= "ID_MONITOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_DISPONIBILIDADE")
    )
    private List<Disponibilidade> disponibilidades;
}
