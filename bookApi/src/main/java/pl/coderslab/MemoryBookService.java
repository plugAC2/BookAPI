package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemoryBookService implements BookService{
    List<Book> books;
    long nextBookId = 0;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
        nextBookId = books.size()+1;
    }
    

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void newBook(Book book) {
        book.setId(nextBookId++);
        books.add(book);
    }

    @Override
    public Book showBookById(long id) {
        List<Book> bookId = books.stream()
                .filter(x -> x.getId().equals(id))
                .collect(Collectors.toList());
        return bookId.get(0);
    }

    @Override
    public void changeBookById(Book book) {
        books.stream()
                .filter(x -> x.getId().equals(book.getId()))
                .forEach(y -> {
                    y.setId(book.getId());
                    y.setIsbn(book.getIsbn());
                    y.setTitle(book.getTitle());
                    y.setAuthor(book.getAuthor());
                    y.setPublisher(book.getPublisher());
                    y.setPublisher(book.getType());
                });
    }

    @Override
    public void deleteBookById(long id) {
        books.stream()
                .filter(x -> x.getId().equals(id))
                .forEach(x -> books.remove(x));
    }
}
