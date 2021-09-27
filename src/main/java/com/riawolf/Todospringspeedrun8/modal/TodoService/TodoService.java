package com.riawolf.Todospringspeedrun8.modal.TodoService;


import com.riawolf.Todospringspeedrun8.modal.MyUserDetailsService.MyUserDetailsService;
import com.riawolf.Todospringspeedrun8.modal.TodoItem.TodoItem;
import com.riawolf.Todospringspeedrun8.modal.TodoMapper.TodoMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {

    private final TodoMapper todoMapper;

    public TodoService(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    public ArrayList<TodoItem> getAllItems(){

        return this.todoMapper.getAllItems(MyUserDetailsService.getCurrentUser().getId());
    }

    public TodoItem addItem(TodoItem todoItem) {
        todoItem.setOwnerId(MyUserDetailsService.getCurrentUser().getId());
        this.todoMapper.addItem(todoItem);
//        this.todoMapper.addItem(todoItem);
        return todoItem;
    }
    public TodoItem updateItem(TodoItem todoItem) {

        this.todoMapper.updateItem(todoItem);
        return todoItem;
    }
    public TodoItem deleteItem(TodoItem todoItem) {
//        todoItem.setOwnerId(MyUserDetailsService.getCurrentUser().getId());

//        todoItem.getOwnerId(MyUserDetailsService.getCurrentUser().getId());
        this.todoMapper.deleteItems(todoItem);
        return todoItem;
    }

}
