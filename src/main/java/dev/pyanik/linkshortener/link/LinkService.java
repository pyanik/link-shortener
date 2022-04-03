package dev.pyanik.linkshortener.link;

public interface LinkService {
    LinkDto createLink(LinkDto Dto);

    LinkDto getLink(String id);
}
