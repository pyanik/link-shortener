package dev.pyanik.linkshortener.controller;

import dev.pyanik.linkshortener.link.LinkAlreadyExistsException;
import dev.pyanik.linkshortener.link.LinkDto;
import dev.pyanik.linkshortener.link.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/links")
public class LinkManageController {

    private final LinkService service;

    LinkManageController(LinkService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> createLink(@RequestBody CreateLinkDto link) {
        try {
            LinkDto linkDto = link.toDto();
            return ResponseEntity
                    .created(URI.create(linkDto.getShortenedLink()))
                    .body(service.createLink(linkDto));
        } catch (LinkAlreadyExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ExceptionResponse(e.getMessage()));
        }

    }
}
