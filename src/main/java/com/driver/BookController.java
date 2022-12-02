package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
      bookService.createBook(book);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book>get_book_by_id(@PathVariable int id){
    	return new ResponseEntity(bookService.findBookById(id),HttpStatus.ACCEPTED);
    }
    
    
    //not working
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> get_all_books(){
    	return new ResponseEntity(bookService.findAllBooks(),HttpStatus.FOUND);
    }
    
    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> get_book_by_author(@RequestParam String author){
    	return new ResponseEntity(bookService.findBooksByAuthor(author),HttpStatus.FOUND);
    }
    
    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> get_book_by_genre(@RequestParam String genre){
    	return new ResponseEntity(bookService.findBooksByGenre(genre),HttpStatus.FOUND);
    }
    
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deletebyid(@PathVariable int id) {
    	bookService.deleteBookById(id);
    	return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/delete-all-books")
    public ResponseEntity deletealbooks() {
    	bookService.deleteAllBooks();
    	return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
