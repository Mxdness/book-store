package com.sakr.bookstore.dto.response;

public record AuthorSummaryResponse(
    Long id,
    String firstName,
    String lastName
) {}
