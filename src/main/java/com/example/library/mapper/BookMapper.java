package com.example.library.mapper;

import com.example.library.dto.BookDTO;
import com.example.library.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public BookDTO toDto(BookEntity book) {
        return new BookDTO(book.getName(), book.getDescription(), book.getId(),book.getAuthor().getName());
    }

    public List<BookDTO> toDtoList(List<BookEntity> books) {
        return books.stream().map(this::toDto).collect(Collectors.toList());
    }
}
