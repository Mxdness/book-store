package com.sakr.bookstore.mapper;

import com.sakr.bookstore.dto.requests.AuthorRequest;
import com.sakr.bookstore.dto.response.AuthorResponse;
import com.sakr.bookstore.dto.response.AuthorSummaryResponse;
import com.sakr.bookstore.model.Author;

public interface AuthorMapper {

    Author toEntity(AuthorRequest request);

    void updateEntity(Author author, AuthorRequest request);

    AuthorResponse toResponse(Author author);

    AuthorSummaryResponse toSummaryResponse(Author author);
}
