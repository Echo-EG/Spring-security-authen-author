package com.riawolf.Todospringspeedrun8.modal.MyUserDetails;

import com.riawolf.Todospringspeedrun8.modal.User.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private Boolean enabled;
//    private List<GrantedAuthority> role;
    private Integer id;




    public MyUserDetails(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getEnabled();
//        this.role = Arrays.stream(user.getRole().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
    }


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return role;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
