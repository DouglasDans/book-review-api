package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.publisher.*;
import dev.dans.bookreview.domain.entities.Author;
import dev.dans.bookreview.domain.entities.Publisher;
import dev.dans.bookreview.infra.adapters.dtos.PublisherDTO;
import dev.dans.bookreview.infra.adapters.mappers.PublisherMapper;
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

    public PublisherDTO create(PublisherDTO publisherDTO){
        Publisher publisher = PublisherMapper.toDomain(publisherDTO);
        publisher = createPublisherUseCase.execute(publisher);
        return PublisherMapper.toJSON(publisher);
    }

    public List<PublisherDTO> findAll(){
        List<Publisher> publishers = findAllPublishersUseCase.execute();
        return publishers.stream()
                .map(PublisherMapper::toJSON)
                .collect(java.util.stream.Collectors.toList());
    }

    public PublisherDTO findById(Long id) throws Exception {
        Publisher publisher = findPublisherByIdUseCase.execute(id);
        return PublisherMapper.toJSON(publisher);
    }

    public PublisherDTO update(PublisherDTO publisherDTO) throws Exception {
        Publisher publisher = PublisherMapper.toDomain(publisherDTO);
        findPublisherByIdUseCase.execute(publisher.getId());
        publisher = updatePublisherUseCase.execute(publisher);
        return PublisherMapper.toJSON(publisher);
    }

    public void delete(Long id) throws Exception {
        findPublisherByIdUseCase.execute(id);
        deletePublisherUseCase.execute(id);
    }
}
