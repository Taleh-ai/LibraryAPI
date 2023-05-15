package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookInputDTO {
    private String name;
    private String description;
    private AuthorDTO authorDTO;
}
