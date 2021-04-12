package com.niculescu.searchTodoMicroservice.controller;

import com.niculescu.searchTodoMicroservice.dto.Todo;
import com.niculescu.searchTodoMicroservice.feignClient.TodoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class SearchForTodosController {

    @Autowired
    private TodoFeignClient todoFeignClient;

    @RequestMapping("/searchTodo/{criteria}")
    public List<Todo> searchTodos(@PathVariable String criteria) {

        List<Todo> listTodos = todoFeignClient.getAllTodos();
        System.out.println("listTodos = " + listTodos);

        List<Todo> foundTodos = listTodos.stream()
                .filter(todo -> todo.getDescription().contains(criteria))
                .collect(Collectors.toList());

        return foundTodos;
    }

}
