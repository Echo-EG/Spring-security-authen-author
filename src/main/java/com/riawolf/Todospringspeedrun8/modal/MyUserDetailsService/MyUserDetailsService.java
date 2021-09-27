package com.riawolf.Todospringspeedrun8.modal.MyUserDetailsService;

import com.riawolf.Todospringspeedrun8.modal.MyUserDetails.MyUserDetails;
import com.riawolf.Todospringspeedrun8.modal.User.User;
import com.riawolf.Todospringspeedrun8.modal.UserMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.security.Principal;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    public static MyUserDetails getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails result = (MyUserDetails) auth.getPrincipal();

        return result;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userMapper.findByUserName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("shit happens"));
        MyUserDetails result = user.map(MyUserDetails::new).get();
        result.setId(user.get().getId());
        return result;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserMapper user = userMapper.findByUserName(username);
//    }
}
