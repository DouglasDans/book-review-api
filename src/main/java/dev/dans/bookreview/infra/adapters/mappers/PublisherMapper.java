package dev.dans.bookreview.infra.adapters.mappers;

import dev.dans.bookreview.domain.entities.Publisher;
import dev.dans.bookreview.infra.adapters.dtos.PublisherDTO;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {
    public static Publisher toDomain(PublisherDTO publisherDTO){
        if(publisherDTO == null) return null;

        Publisher publisher = new Publisher();
        publisher.setId(publisherDTO.getId());
        publisher.setName(publisherDTO.getName());
        return publisher;
    }

    public static PublisherDTO toJSON(Publisher publisher){
        if(publisher == null) return null;

        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setId(publisher.getId());
        publisherDTO.setName(publisher.getName());
        return publisherDTO;
    }
}
