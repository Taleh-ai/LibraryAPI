package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {

    private String name;
    private String description;
    private Long id;
    private String authorName;
}
