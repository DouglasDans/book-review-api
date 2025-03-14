package dev.dans.bookreview.application.usecase.publisher;

import dev.dans.bookreview.domain.entities.Publisher;
import dev.dans.bookreview.domain.repository.PublisherRepository;
import dev.dans.bookreview.shared.exceptions.ResourceDataNullException;
import org.springframework.stereotype.Component;

@Component
public class CreatePublisherUseCase {
    private final PublisherRepository publisherRepository;

    public CreatePublisherUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher execute(Publisher publisher) {
        verifyNullAttributes(publisher);
        return publisherRepository.save(publisher);
    }

    private void verifyNullAttributes(Publisher publisher) {
        if (publisher.getName() == null || publisher.getName().isEmpty()) {
            throw new ResourceDataNullException("Publisher name");
        }
    }
}
