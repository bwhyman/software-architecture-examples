package com.example.softwarearchitectureexamples.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Integer id;
    private String detail;
    private Integer userId;
}
