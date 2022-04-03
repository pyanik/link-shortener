package dev.pyanik.linkshortener.link;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
class LinkEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String targetUrl;
    private LocalDate expirationDate;
    private int visits;
    public LinkEntity(String id, String email, String targetUrl, LocalDate expirationDate, int visits) {
        this.id = id;
        this.email = email;
        this.targetUrl = targetUrl;
        this.expirationDate = expirationDate;
        this.visits = visits;
    }

    public LinkEntity() {
    }

    static LinkEntity fromDto(LinkDto link) {
        return new LinkEntity(
                link.id(),
                link.email(),
                link.targetUrl(),
                link.expirationDate(),
                link.visits()
        );
    }

    LinkDto toDto() {
        return new LinkDto(id, email, targetUrl, expirationDate, visits);
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public int getVisits() {
        return this.visits;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }
}
