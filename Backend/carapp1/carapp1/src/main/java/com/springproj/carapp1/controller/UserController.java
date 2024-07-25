package com.springproj.carapp1.controller;
import com.springproj.carapp1.entity.UserInfo;
import com.springproj.carapp1.jwtmodal.AuthRequest;
import com.springproj.carapp1.service.JwtService;
import com.springproj.carapp1.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    private UserInfoService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserInfo> addUser(@RequestBody UserInfo user){
        UserInfo savedUser= userService.addUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUser_name(), authRequest.getPassword()));

        if (authentication.isAuthenticated()) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            System.out.println("Authorities: " + authorities);
          return   jwtService.generateToken(authRequest.getUser_name())+" "+authorities;


        } else {
            throw new UsernameNotFoundException("invalid user request");
        }
    }




}

