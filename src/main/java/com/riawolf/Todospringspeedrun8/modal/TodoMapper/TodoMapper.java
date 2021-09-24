package com.riawolf.Todospringspeedrun8.modal.TodoMapper;


import com.riawolf.Todospringspeedrun8.modal.TodoItem.TodoItem;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM `Todo_table`")
    ArrayList<TodoItem>getAllItems();

    @Insert("INSERT INTO `Todo_table` (`title`) VALUES (#{title})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addItem(TodoItem todoItem);

    @Update("UPDATE `Todo_table` SET `title` = #{title}, `checked` = #{checked} WHERE `Todo_table`.`id` = #{id}")
    void updateItem(TodoItem todoItem);

    @Delete("DELETE FROM `Todo_table` WHERE id = #{id}")
    void deleteItems(TodoItem todoItem);

}
