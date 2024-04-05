package com.leonardo.duck.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sales")
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "price", nullable = false)
    private Float price;

    @ManyToOne
    @JoinColumn(name = "id_duck", referencedColumnName = "id")
    private Duck duck;

    @Transient // Esta anotação indica que esse campo não deve ser persistido no banco de dados
    private Long duckId; // Campo para armazenar apenas o ID da mãe

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;

    @Transient // Esta anotação indica que esse campo não deve ser persistido no banco de dados
    private Long clientId; // Campo para armazenar apenas o ID da mãe

    @Builder
    public Sale(Float price, Long duckId, Long clientId) {
        this.price = price;
        this.duckId = duckId;
        this.clientId = clientId;
    }



}
