package com.springproj.carapp1.jwtmodal;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthRequest {

    private String user_name;
    private String password;
}