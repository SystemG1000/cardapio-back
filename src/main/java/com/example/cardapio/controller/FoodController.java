package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indicar que essa classe é um controller
@RequestMapping("food") // Indicar o endpoint que o controller controla
public class FoodController {
    @Autowired // Anotação para o Spring injetar uma dependência
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*") // Permitir todas as origens e todos os headers
    @PostMapping // Mapea para o Spring a classe responsavel de lidar com as requisições do tipo post
    public void saveFood(@RequestBody FoodRequestDTO data){ // Indicando para o Spring que o parametro é um Body que veio la do request do cliente
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping // Quando bater nesse endpoint food com o método get executa esse método da classe: getAll
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList(); // stream() -> esse método vai pegar tudo que está vindo do repository com o método findAll() e vai colocar dentro de um funil
        return foodList;
    }
}

/*

// Não é uma boa prática retornar o objeto food como uma lista
// O certo seria criar uma nova classe que vai ser o DTO(data transfer object)

@RestController // Indicar que essa classe é um controller
@RequestMapping("food") // Indicar o endpoint que o controller controla
public class FoodController {
    @Autowired // Anotação para o Spring injetar uma dependência
    private FoodRepository repository;
    @GetMapping // Quando bater nesse endpoint food com o método get executa esse método da classe: getAll
    public List<Food> getAll() {
        List<Food> foodList = repository.findAll();
        return foodList;
    }
}
 */
