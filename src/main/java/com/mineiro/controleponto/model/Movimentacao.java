package com.mineiro.controleponto.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Audited
public class Movimentacao {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    //chave composta = Id Movimento + Id Usuario
    public  class  MovimentacaoId implements Serializable {
        private long idMovimento;
        private long idUsuario;
    }

    @EmbeddedId
    @GeneratedValue
    private MovimentacaoId movimentacaoId;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;

    @ManyToOne
    private Ocorrencia ocorrencia;

    @ManyToOne
    private Calendario calendario;
}
