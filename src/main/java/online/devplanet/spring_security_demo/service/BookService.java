package online.devplanet.spring_security_demo.service;

import online.devplanet.spring_security_demo.Repo.BookRepo;
import online.devplanet.spring_security_demo.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;


    public List<Books> getAllBooks() {
        return bookRepo.findAll();
    }

    public Books addBook(Books book) {
        return bookRepo.save(book);
    }
}
