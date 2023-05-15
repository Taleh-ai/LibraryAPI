package com.example.library.controller;

import com.example.library.dto.AuthorDTO;
import com.example.library.dto.BookDTO;
import com.example.library.dto.BookInputDTO;
import com.example.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LibraryController {
    private  final LibraryService libraryService;

    @PostMapping("/add_book")
    public void addbook(@RequestBody BookInputDTO bookDTO){
        libraryService.addBook(bookDTO);
    }
    @PostMapping("/addauthor")
    public void addAuthor(AuthorDTO authorDTO){
        libraryService.addAuthor(authorDTO);
    }

    @GetMapping("/allBook")
    public List<BookDTO> allBook(){
      return  libraryService.allBook();
    }
}
