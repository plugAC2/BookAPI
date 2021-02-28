package pl.coderslab.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Book;
import pl.coderslab.BookService;
import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    @ResponseBody
    public List<Book> showBooks()  {
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }

    @PostMapping("/books")
    @ResponseBody
    public String addBook(@RequestBody Book book){
        bookService.newBook(book);
        return "Dodano: " + book;
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public Book showBook(@PathVariable long id){
        try {
            return bookService.showBookById(id);
        } catch (IndexOutOfBoundsException e){
            return new Book(999999999L, "Not existent", "Not existent", "Not existent", "Not existent", "Not existent");
        }
    }

    @PutMapping ("/books")
    @ResponseBody
    public void changeBook(@RequestBody Book book){
        bookService.changeBookById(book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id){
        try {
            bookService.deleteBookById(id);
            return "deleted";
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            return "error";
        }

    }
}
