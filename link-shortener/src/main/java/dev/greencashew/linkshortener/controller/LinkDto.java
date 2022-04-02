package dev.greencashew.linkshortener.controller;

import java.time.LocalDate;

record LinkDto(
        String id,
        String email,
        String targetUrl,
        LocalDate expirationDate,
        int visits
) {

}
