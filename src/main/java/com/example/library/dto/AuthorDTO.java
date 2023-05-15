package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorDTO {
    String name;
    int birthYear;
}
