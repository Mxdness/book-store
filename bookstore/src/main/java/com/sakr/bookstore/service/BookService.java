package com.sakr.bookstore.service;

import com.sakr.bookstore.dto.requests.BookRequest;
import com.sakr.bookstore.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse createBook(BookRequest request);

    List<BookResponse> getAllBooks();

    BookResponse getBookByIsbn(String isbn);

    BookResponse updateBook(Long id, BookRequest request);

    void deleteBook(Long id);
}
