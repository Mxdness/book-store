package com.sakr.bookstore.mapper;

import com.sakr.bookstore.dto.requests.BookRequest;
import com.sakr.bookstore.dto.response.BookResponse;
import com.sakr.bookstore.model.Author;
import com.sakr.bookstore.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapperImpl implements BookMapper {

    private final AuthorMapper authorMapper;

    @Override
    public Book toEntity(BookRequest request, Author author) {
        Book book = new Book();
        book.setTitle(request.title());
        book.setIsbn(request.isbn());
        book.setPrice(request.price());
        book.setAuthor(author);
        return book;
    }

    @Override
    public void updateEntity(Book book, BookRequest request, Author author) {
        book.setTitle(request.title());
        book.setIsbn(request.isbn());
        book.setPrice(request.price());
        book.setAuthor(author);
    }

    @Override
    public BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPrice(),
                authorMapper.toSummaryResponse(book.getAuthor())
        );
    }
}
