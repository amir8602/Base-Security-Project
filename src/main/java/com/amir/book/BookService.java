package com.amir.book;

import org.springframework.stereotype.Service;

@Service
public interface BookService {

    public BookModel addBook(BookModel modelFromController);

}
