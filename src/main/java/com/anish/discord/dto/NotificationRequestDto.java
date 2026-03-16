package com.anish.discord.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Schema(description = "Request dto for sending discord server notifications")
public record NotificationRequestDto(

        @NotBlank
        @Schema(description = "Title of the notification", example = "Server Down")
        String title,

        @NotBlank
        @Schema(description = "Subtitle of the notification", example = "Production Alert")
        String subtitle,

        @NotBlank
        @Schema(description = "Main content of the notification", example = "The production server is down since 2 PM")
        String content,

        @NotBlank
        @Schema(description = "The display text for the embedded hyperlink", example = "View Details")
        String linkText,

        @NotBlank
        @URL
        @Schema(description = "The URL the embedded hyperlink points to", example = "https://www.google.com")
        String linkUrl
) { }
