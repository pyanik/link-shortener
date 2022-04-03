package dev.pyanik.linkshortener.controller;

import dev.pyanik.linkshortener.link.LinkDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

record CreateLinkDto(
        @Schema(description = "Identifier/alias to link. Used for redirection.", example = "link-alias", required = true)
        String id,
        @Schema(description = "E-mail address of the user.", example = "piotr.nowak@mail.com", required = true)
        String email,
        @Schema(description = "Link to be shortened.", example = "https://www.google.pl/", required = true)
        String targetUrl,
        @Schema(description = "Date of expiration of the shortened link.", example = "30.04.2022", required = false)
        LocalDate expirationDate) {

    public LinkDto toDto() {
        return new LinkDto(
                id,
                email,
                targetUrl,
                expirationDate,
                0
        );
    }
}
