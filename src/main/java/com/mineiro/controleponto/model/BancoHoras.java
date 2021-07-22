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
public class BancoHoras {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    //chave composta = Id BancoHoras + Id Movimentacao + Id Usuario
    public  class BancoHorasId implements Serializable {
        private long idBancoHoras;
        private long idMovimentacao;
        private long idUsuario;
    }

    @EmbeddedId
    @GeneratedValue
    private BancoHorasId bancoHorasId;

    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;
}
