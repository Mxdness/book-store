package com.sakr.bookstore.mapper;

import com.sakr.bookstore.dto.requests.BookRequest;
import com.sakr.bookstore.dto.response.BookResponse;
import com.sakr.bookstore.model.Author;
import com.sakr.bookstore.model.Book;

public interface BookMapper {

    Book toEntity(BookRequest request, Author author);

    void updateEntity(Book book, BookRequest request, Author author);

    BookResponse toResponse(Book book);
}
