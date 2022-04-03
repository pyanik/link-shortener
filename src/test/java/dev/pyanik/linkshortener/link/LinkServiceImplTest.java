package dev.pyanik.linkshortener.link;

import org.junit.jupiter.api.Test;

class LinkServiceImplTest {

    @Test
    void shouldThrowExceptionWhenLinkIsDuplicated() {
        // given
        LinkDto firstDto = new LinkDto("test", "test@email.com", "http://google.pl", null, 0);
        LinkDto secondDto = new LinkDto("test", "haker@email.com", "http://google.pl", null, 0);

        LinkService service = new LinkServiceImpl();
        service.createLink(firstDto);

        //when

        try {
            service.createLink(secondDto);
            assert false;
        } catch (LinkAlreadyExistsException e) {
            assert true;
            System.out.println("Mamy wyjątek: " + e.getMessage());
        }
        System.out.println("Koniec Testu");

        //then
    }
}