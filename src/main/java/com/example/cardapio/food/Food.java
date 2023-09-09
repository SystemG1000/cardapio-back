package com.example.cardapio.food;

import jakarta.persistence.*;

// Classe indica uma entidade do nosso banco de dados
@Table(name = "foods")  // Nome da tabela
@Entity(name = "foods") // Nome da entidade
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;
}
