package dev.pyanik.linkshortener.link;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

public record LinkDto(
        @Schema(description = "Identifier/alias to link. Used for redirection.", example = "link-alias", required = true)
        String id,
        @Schema(description = "E-mail address of the user.", example = "piotr.nowak@mail.com", required = true)
        @JsonIgnore String email,
        @Schema(description = "Link to be shortened.", example = "https://www.google.pl/", required = true)
        String targetUrl,
        @Schema(description = "Date of expiration of the shortened link.", example = "30.04.2022", required = false)
        LocalDate expirationDate,
        @Schema(description = "Number of visits to the page via a shortened link.", example = "7", required = false)
        int visits
) {
        public String getShortenedLink() {
                return ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/s/{id}")
                        .buildAndExpand(id)
                        .toUriString();
        }

}
