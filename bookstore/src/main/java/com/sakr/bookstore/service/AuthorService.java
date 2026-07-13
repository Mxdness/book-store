package com.sakr.bookstore.service;

import com.sakr.bookstore.dto.requests.AuthorRequest;
import com.sakr.bookstore.dto.response.AuthorResponse;

import java.util.List;

public interface AuthorService {

    AuthorResponse createAuthor(AuthorRequest request);

    List<AuthorResponse> getAllAuthors();

    AuthorResponse getAuthorById(Long id);

    AuthorResponse updateAuthor(Long id, AuthorRequest request);

    void deleteAuthor(Long id);
}