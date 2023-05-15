package com.example.library.repository;

import com.example.library.dto.AuthorDTO;
import com.example.library.entity.AuthorEntity;
import com.example.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findByNameContainingIgnoreCase(String name);

}
