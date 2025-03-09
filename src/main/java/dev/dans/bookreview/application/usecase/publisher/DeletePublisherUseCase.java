package dev.dans.bookreview.application.usecase.publisher;

import dev.dans.bookreview.domain.repository.PublisherRepository;
import org.springframework.stereotype.Component;

@Component
public class DeletePublisherUseCase {
    private final PublisherRepository publisherRepository;

    public DeletePublisherUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void execute(Long id) {
        publisherRepository.deleteById(id);
    }
}
