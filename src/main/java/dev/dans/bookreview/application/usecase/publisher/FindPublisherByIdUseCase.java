package dev.dans.bookreview.application.usecase.publisher;

import dev.dans.bookreview.domain.entities.Publisher;
import dev.dans.bookreview.domain.repository.PublisherRepository;
import dev.dans.bookreview.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindPublisherByIdUseCase {
    private final PublisherRepository publisherRepository;

    public FindPublisherByIdUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher execute(Long id){
        Optional<Publisher> publisher = publisherRepository.findById(id);

        if (publisher.isEmpty()) throw new ResourceNotFoundException("Publisher ID:" + id + " not found");

        return publisher.get();
    }
}
