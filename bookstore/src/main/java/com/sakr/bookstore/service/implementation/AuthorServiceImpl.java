package com.sakr.bookstore.service.implementation;

import com.sakr.bookstore.dto.requests.AuthorRequest;
import com.sakr.bookstore.dto.response.AuthorResponse;
import com.sakr.bookstore.exception.ResourceNotFoundException;
import com.sakr.bookstore.mapper.AuthorMapper;
import com.sakr.bookstore.model.Author;
import com.sakr.bookstore.repository.AuthorRepository;
import com.sakr.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorResponse createAuthor(AuthorRequest request) {
        Author author = authorMapper.toEntity(request);
        return authorMapper.toResponse(authorRepository.save(author));
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toResponse)
                .toList();
    }

    @Override
    public AuthorResponse getAuthorById(Long id) {
        return authorMapper.toResponse(findAuthorOrThrow(id));
    }

    @Override
    public AuthorResponse updateAuthor(Long id, AuthorRequest request) {
        Author author = findAuthorOrThrow(id);
        authorMapper.updateEntity(author, request);
        return authorMapper.toResponse(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = findAuthorOrThrow(id);
        authorRepository.delete(author);
    }

    private Author findAuthorOrThrow(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }
}
