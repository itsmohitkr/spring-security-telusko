package online.devplanet.spring_security_demo.Controller;

import online.devplanet.spring_security_demo.model.Books;
import online.devplanet.spring_security_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    public Books addBook(@RequestBody Books book){
        return bookService.addBook(book);
    }
}
