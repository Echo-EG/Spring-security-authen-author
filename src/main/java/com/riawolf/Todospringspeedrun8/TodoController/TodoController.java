package com.riawolf.Todospringspeedrun8.TodoController;


import com.riawolf.Todospringspeedrun8.modal.TodoItem.TodoItem;
import com.riawolf.Todospringspeedrun8.modal.TodoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todo")
    public ArrayList<TodoItem> getTodo(){
        return this.todoService.getAllItems();
    }


    @PostMapping("/post")
    public TodoItem postTodo(@RequestBody TodoItem todoItem){
        TodoItem result = this.todoService.addItem(todoItem);
        return result;
    }

    @PutMapping("/{id}")
    public TodoItem putTodo(@RequestBody TodoItem todoItem){
        this.todoService.updateItem(todoItem);
        return todoItem;
    }

    @DeleteMapping("delete/{id}")
    public void deleteItem(TodoItem todoItem){
        this.todoService.deleteItem(todoItem);
    }

}
