package com.sakr.bookstore.service.implementation;

import com.sakr.bookstore.dto.requests.BookRequest;
import com.sakr.bookstore.dto.response.BookResponse;
import com.sakr.bookstore.exception.ResourceNotFoundException;
import com.sakr.bookstore.mapper.BookMapper;
import com.sakr.bookstore.model.Author;
import com.sakr.bookstore.model.Book;
import com.sakr.bookstore.repository.AuthorRepository;
import com.sakr.bookstore.repository.BookRepository;
import com.sakr.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponse createBook(BookRequest request) {
        Author author = findAuthorOrThrow(request.authorId());
        Book book = bookMapper.toEntity(request, author);
        return bookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getBookByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ISBN: " + isbn));
        return bookMapper.toResponse(book);
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest request) {
        Book book = findBookOrThrow(id);
        Author author = findAuthorOrThrow(request.authorId());
        bookMapper.updateEntity(book, request, author);
        return bookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        Book book = findBookOrThrow(id);
        bookRepository.delete(book);
    }

    private Book findBookOrThrow(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    private Author findAuthorOrThrow(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
    }
}