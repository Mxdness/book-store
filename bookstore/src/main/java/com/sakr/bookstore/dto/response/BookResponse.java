package com.sakr.bookstore.dto.response;

import java.math.BigDecimal;

public record BookResponse(
    Long id,
    String title,
    String isbn,
    BigDecimal price,
    AuthorSummaryResponse author
) {}
