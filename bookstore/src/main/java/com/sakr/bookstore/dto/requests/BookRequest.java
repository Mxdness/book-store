package com.sakr.bookstore.dto.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record BookRequest(

    @NotBlank(message = "Title is required")
    String title,

    @NotBlank(message = "ISBN is required")
    String isbn,

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    BigDecimal price,

    @NotNull(message = "Author id is required")
    Long authorId
) {}