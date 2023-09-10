package com.example.cardapio.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Classe indica uma entidade do nosso banco de dados
@Table(name = "foods")  // Nome da tabela
@Entity(name = "foods") // Nome da entidade
@Getter // solicita para o Lombok em runtime gerar todos os métodos de get
@NoArgsConstructor // Lombok declara um construtor que recebe nenhum argumento
@AllArgsConstructor // Lombok declara um construtor que recebe todos os argumentos
@EqualsAndHashCode(of = "id") // Representa que o "id" é a representação única de Food
public class Food { // Com isso o id gerado para os elementos será em ordem númerica e não aleatoriamente
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // Recomendado usar UUID para aplicações reais
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Food(FoodRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }
}
