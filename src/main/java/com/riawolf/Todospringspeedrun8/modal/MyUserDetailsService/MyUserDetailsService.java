package com.riawolf.Todospringspeedrun8.modal.MyUserDetailsService;

import com.riawolf.Todospringspeedrun8.modal.MyUserDetails.MyUserDetails;
import com.riawolf.Todospringspeedrun8.modal.User.User;
import com.riawolf.Todospringspeedrun8.modal.UserMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userMapper.findByUserName(username);

        user.orElseThrow(() -> new  UsernameNotFoundException("shit happens"));

        return user.map(MyUserDetails::new).get();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserMapper user = userMapper.findByUserName(username);
//    }
}
