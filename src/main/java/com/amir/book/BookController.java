package com.amir.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/getAddBookPage" , method = RequestMethod.GET)
    public String getAddPage(){
        return "add-book";
    }


    @RequestMapping(value = "/addBook" , method = RequestMethod.POST)
    public String addBook(BookModel bookModelFromUi){
        BookModel bookModelAfterAddToDatabase = bookService.addBook(bookModelFromUi);
        System.out.println(bookModelAfterAddToDatabase);
        return "redirect:/";
    }

}
