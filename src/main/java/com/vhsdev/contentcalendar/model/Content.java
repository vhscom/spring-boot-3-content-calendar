package com.vhsdev.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record Content(
    Integer id,
    // If we did nothing else, this wouldn't work. Use along with @Valid in the controller.
    @NotBlank
    String title,
    String description,
    Status status,
    Type contentType,
    LocalDateTime dateCreated,
    LocalDateTime dateUpdated,
    String url
) { }
