package dev.dans.bookreview.application.usecase.publisher;

import dev.dans.bookreview.domain.entities.Publisher;
import dev.dans.bookreview.domain.repository.PublisherRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllPublishersUseCase {
    private final PublisherRepository publisherRepository;

    public FindAllPublishersUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> execute() {
        return publisherRepository.findAll();
    }
}
