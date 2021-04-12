package com.niculescu.searchTodoMicroservice.feignClient;

import com.niculescu.searchTodoMicroservice.dto.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("todoMicroservice")
public interface TodoFeignClient {

    @RequestMapping("/service/todos")
    List<Todo> getAllTodos();

    @RequestMapping("/service/todos/user/{userName}")
    List<Todo>  getAllTodosForUser(@PathVariable String userName);

    @GetMapping("/service/todos/{id}")
    Todo getTodoById(@PathVariable long id);

}
