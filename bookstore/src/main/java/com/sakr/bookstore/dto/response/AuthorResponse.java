package com.sakr.bookstore.dto.response;

public record AuthorResponse(
    Long id,
    String firstName,
    String lastName,
    String biography
) {}