package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
