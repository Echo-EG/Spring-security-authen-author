package com.riawolf.Todospringspeedrun8.modal.TodoItem;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {
    private Integer id;
    private String title;
    private Boolean checked = false;
}
