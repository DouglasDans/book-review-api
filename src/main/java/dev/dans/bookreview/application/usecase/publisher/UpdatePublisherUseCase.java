package dev.dans.bookreview.application.usecase.publisher;

import dev.dans.bookreview.domain.entities.Publisher;
import dev.dans.bookreview.domain.repository.PublisherRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdatePublisherUseCase {
    private final PublisherRepository publisherRepository;

    public UpdatePublisherUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher execute(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}
