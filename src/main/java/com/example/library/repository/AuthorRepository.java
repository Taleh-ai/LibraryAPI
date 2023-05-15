package com.example.library.repository;

import com.example.library.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
    List<AuthorEntity> findByNameContainingIgnoreCase(String name);
}
