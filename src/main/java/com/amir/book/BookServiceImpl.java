package com.amir.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public BookModel addBook(BookModel modelFromController) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(modelFromController.getName());
        bookEntity.setAuthorName(modelFromController.getAuthorName());
        bookEntity.setCount(modelFromController.getCount());

        BookEntity save = bookRepository.save(bookEntity);

        BookModel bookModel = new BookModel();
        bookModel.setId(save.getId());
        bookModel.setName(save.getName());
        bookModel.setAuthorName(save.getAuthorName());
        bookModel.setCount(save.getCount());

        return bookModel;
    }

}
