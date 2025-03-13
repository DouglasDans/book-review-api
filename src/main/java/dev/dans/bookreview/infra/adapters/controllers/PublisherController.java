package dev.dans.bookreview.infra.adapters.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.application.service.PublisherService;
import dev.dans.bookreview.infra.adapters.dtos.PublisherDTO;
import dev.dans.bookreview.infra.response.RestResponse;
import dev.dans.bookreview.infra.response.RestResponseBuilder;
import dev.dans.bookreview.infra.views.Views;
import dev.dans.bookreview.shared.utils.GetResponseSelfLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<RestResponse<List<PublisherDTO>>> getAllPublishers() {
        List<PublisherDTO> publishers = publisherService.findAll();
        return RestResponseBuilder.build(
                publishers,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<PublisherDTO>> getPublisher(@PathVariable Long id) throws Exception {
        PublisherDTO publisher = publisherService.findById(id);
        return RestResponseBuilder.build(
                publisher,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<RestResponse<PublisherDTO>> createPublisher(
            @RequestBody @JsonView(Views.PublisherRequest.class) PublisherDTO publisher
    ) {
        PublisherDTO createdPublisher = publisherService.create(publisher);
        return RestResponseBuilder.build(
                createdPublisher,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.CREATED
        );
    }

    @PatchMapping
    public ResponseEntity<RestResponse<PublisherDTO>> updatePublisher(PublisherDTO publisher) throws Exception {
        PublisherDTO updatedPublisher = publisherService.update(publisher);
        return RestResponseBuilder.build(
                updatedPublisher,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> deletePublisher(@PathVariable Long id) throws Exception {
        publisherService.delete(id);
        return RestResponseBuilder.build(
                "Review deleted successfully",
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }
}
