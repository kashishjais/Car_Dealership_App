package com.springproj.carapp1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userinfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String user_name;
    private String password;

    private String role="ROLE_USER";

//    public UserInfo(Long id, String user_name, String password, List<Roles> role) {
//        this.id=id;
//        this.user_name = user_name;
//        this.password = password;
//        //this.role = "user";
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.user_name;
//    }
//
//    public List<Roles> getRoles() {
//        return List.of();
//    }
}