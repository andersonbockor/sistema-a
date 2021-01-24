package com.sistemaa.sistemaa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "divida")
public class Divida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("dividas")
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    @Column(name = "valor_credito")
    private BigDecimal valorCredito;

    @Column(name = "valor_devido")
    private BigDecimal valorDevido;

    @Column(name = "saldo_devido")
    private BigDecimal saldoDevido;

    @Column(name = "valor_pago")
    private BigDecimal valorPago;

    @Column(name = "data_credito")
    private Date dataCredito;

    @Column(name = "data_quitacao")
    private Date dataQuitacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", nullable = false)
    private SituacaoEnum cidade;

    @Column(name = "instituicao")
    private String instituicao;

    @Column(name = "dias_atraso")
    private int diasAtraso;

}
