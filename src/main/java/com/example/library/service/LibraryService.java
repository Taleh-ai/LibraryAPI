package com.example.library.service;

import com.example.library.dto.AuthorDTO;
import com.example.library.dto.BookDTO;
import com.example.library.dto.BookInputDTO;
import com.example.library.entity.AuthorEntity;
import com.example.library.entity.BookEntity;
import com.example.library.mapper.BookMapper;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public void addBook(BookInputDTO bookDTO){
        AuthorEntity authorEntity = (AuthorEntity) authorRepository.findByNameContainingIgnoreCase(bookDTO.getAuthorDTO().getName());
        if(authorEntity == null){
            AuthorEntity  author = new AuthorEntity();
            author.setName(bookDTO.getAuthorDTO().getName());
            author.setBirthYear(bookDTO.getAuthorDTO().getBirthYear());
            authorRepository.save(author);
            BookEntity bookEntity = new BookEntity();
            bookEntity.setName(bookDTO.getName());
            bookEntity.setDescription(bookEntity.getDescription());
            bookEntity.setAuthor(author);
            bookRepository.save(bookEntity);
        }else {
            BookEntity bookEntity = new BookEntity();
            bookEntity.setName(bookDTO.getName());
            bookEntity.setDescription(bookEntity.getDescription());
            bookEntity.setAuthor(authorEntity);
            bookRepository.save(bookEntity);
        }

    }

    public void addAuthor(AuthorDTO authorDTO){
        if(authorRepository.findByNameContainingIgnoreCase(authorDTO.getName())==null){
            AuthorEntity author = new AuthorEntity();
            author.setName(authorDTO.getName());
            author.setBirthYear(authorDTO.getBirthYear());
            authorRepository.save(author);
        }else{
            System.out.println("This author exist");
        }

    }
    public List<AuthorEntity> allAuthor(){
        authorRepository.findAll();
        return null;
    }
    public List<BookDTO> allBook(){
       return  bookMapper.toDtoList(bookRepository.findAll());

    }
}
