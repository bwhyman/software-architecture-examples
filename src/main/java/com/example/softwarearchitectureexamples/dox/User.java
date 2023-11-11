package com.example.softwarearchitectureexamples.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public static final int USER = 1;
    public static final int ADMIN = 10;

    @Id
    private Integer id;
    private String account;
    private String password;
    private Integer role;
}
