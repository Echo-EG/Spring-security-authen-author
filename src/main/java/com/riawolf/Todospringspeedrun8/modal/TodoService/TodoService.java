package com.riawolf.Todospringspeedrun8.modal.TodoService;


import com.riawolf.Todospringspeedrun8.modal.TodoItem.TodoItem;
import com.riawolf.Todospringspeedrun8.modal.TodoMapper.TodoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {

    private final TodoMapper todoMapper;

    public TodoService(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    public ArrayList<TodoItem> getAllItems(){
        return this.todoMapper.getAllItems();
    }

    public TodoItem addItem(TodoItem todoItem) {
        this.todoMapper.addItem(todoItem);
        return todoItem;
    }
    public TodoItem updateItem(TodoItem todoItem) {
        this.todoMapper.updateItem(todoItem);
        return todoItem;
    }
    public TodoItem deleteItem(TodoItem todoItem) {
        this.todoMapper.deleteItems(todoItem);
        return todoItem;
    }

}
