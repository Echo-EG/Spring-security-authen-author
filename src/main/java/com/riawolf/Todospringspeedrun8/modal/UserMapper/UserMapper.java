package com.riawolf.Todospringspeedrun8.modal.UserMapper;

import com.riawolf.Todospringspeedrun8.modal.MyUserDetails.MyUserDetails;
import com.riawolf.Todospringspeedrun8.modal.TodoItem.TodoItem;
import com.riawolf.Todospringspeedrun8.modal.User.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Optional;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM Users where username = #{username}")
    Optional<User> findByUserName(String username);

}
