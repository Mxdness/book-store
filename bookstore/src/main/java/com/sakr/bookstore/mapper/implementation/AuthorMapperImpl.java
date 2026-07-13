package com.sakr.bookstore.mapper.implementation;

import com.sakr.bookstore.dto.requests.AuthorRequest;
import com.sakr.bookstore.dto.response.AuthorResponse;
import com.sakr.bookstore.dto.response.AuthorSummaryResponse;
import com.sakr.bookstore.mapper.AuthorMapper;
import com.sakr.bookstore.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toEntity(AuthorRequest request) {
        Author author = new Author();
        author.setFirstName(request.firstName());
        author.setLastName(request.lastName());
        author.setBiography(request.biography());
        return author;
    }

    @Override
    public void updateEntity(Author author, AuthorRequest request) {
        author.setFirstName(request.firstName());
        author.setLastName(request.lastName());
        author.setBiography(request.biography());
    }

    @Override
    public AuthorResponse toResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getBiography()
        );
    }

    @Override
    public AuthorSummaryResponse toSummaryResponse(Author author) {
        return new AuthorSummaryResponse(
                author.getId(),
                author.getFirstName(),
                author.getLastName()
        );
    }
}
