package pl.coderslab;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    void newBook(Book book);
    Book showBookById(long id);
    void changeBookById(Book book);
    void deleteBookById(long id);
}
