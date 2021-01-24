package com.sistemaa.sistemaa.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf")
    private String nome;

    @Column(name = "nome")
    private String email;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "numero_endereco")
    private String numeroEndereco;

    @Column(name = "complemento_endereco")
    private String complementoEndereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @OneToMany(mappedBy = "pessoa")
    private List<Divida> dividas;

}
