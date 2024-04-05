package com.leonardo.duck.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ducks")
@NoArgsConstructor
public class Duck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_mae", referencedColumnName = "id")
    private Duck mae;

    @Transient // Esta anotação indica que esse campo não deve ser persistido no banco de dados
    private Long maeId; // Campo para armazenar apenas o ID da mãe

    @Builder
    public Duck(String name, Long maeId) {
        this.name = name;
        this.maeId = maeId;
    }
}
