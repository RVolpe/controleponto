package com.mineiro.controleponto.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Audited
public class Localidade {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    private String descricao;
}
