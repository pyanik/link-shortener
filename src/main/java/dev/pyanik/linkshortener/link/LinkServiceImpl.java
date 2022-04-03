package dev.pyanik.linkshortener.link;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository repository;

    LinkServiceImpl(LinkRepository repository) {
        this.repository = repository;
    }


    @Override
    public LinkDto createLink(LinkDto dto) throws LinkAlreadyExistsException {
        Optional<LinkEntity> linkEntity = repository.findById(dto.id());
        if (linkEntity.isPresent()) {
            throw new LinkAlreadyExistsException(dto.id());
        }
        repository.save(LinkEntity.fromDto(dto));
        return dto;
    }

    @Override
    public LinkDto getLink(String id) {
        return repository.findById(id)
                .map(LinkEntity::toDto)
                .orElse(null);
    }
}
