package com.mineiro.controleponto.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
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
public class Usuario {

    @Id
    @GeneratedValue
    private long id;
    private String nome;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;

    private BigDecimal tolerancia;
    private LocalDateTime inicioJornada;
    private LocalDateTime finalJornada;
}
