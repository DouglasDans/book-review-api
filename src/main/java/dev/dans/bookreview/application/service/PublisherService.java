package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.publisher.*;
import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.domain.entities.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final CreatePublisherUseCase createPublisherUseCase;
    private final DeletePublisherUseCase deletePublisherUseCase;
    private final FindAllPublishersUseCase findAllPublishersUseCase;
    private final FindPublisherByIdUseCase findPublisherByIdUseCase;
    private final UpdatePublisherUseCase updatePublisherUseCase;

    public PublisherService(CreatePublisherUseCase createPublisherUseCase,
                            DeletePublisherUseCase deletePublisherUseCase,
                            FindAllPublishersUseCase findAllPublishersUseCase,
                            FindPublisherByIdUseCase findPublisherByIdUseCase,
                            UpdatePublisherUseCase updatePublisherUseCase) {
        this.createPublisherUseCase = createPublisherUseCase;
        this.deletePublisherUseCase = deletePublisherUseCase;
        this.findAllPublishersUseCase = findAllPublishersUseCase;
        this.findPublisherByIdUseCase = findPublisherByIdUseCase;
        this.updatePublisherUseCase = updatePublisherUseCase;
    }

    public Publisher create(Publisher publisher){
        return createPublisherUseCase.execute(publisher);
    }

    public List<Publisher> findAll(){
        return findAllPublishersUseCase.execute();
    }

    public Publisher findById(Long id) throws Exception {
        return findPublisherByIdUseCase.execute(id);
    }

    public Publisher update(Publisher publisher) throws Exception {
        findPublisherByIdUseCase.execute(publisher.getId());
        return updatePublisherUseCase.execute(publisher);
    }

    public void delete(Long id) throws Exception {
        findPublisherByIdUseCase.execute(id);
        deletePublisherUseCase.execute(id);
    }
}
