package dev.dans.bookreview.infra.adapters.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.dans.bookreview.application.service.CategoryService;
import dev.dans.bookreview.infra.adapters.dtos.CategoryDTO;
import dev.dans.bookreview.infra.response.RestResponse;
import dev.dans.bookreview.infra.response.RestResponseBuilder;
import dev.dans.bookreview.infra.views.Views;
import dev.dans.bookreview.shared.utils.GetResponseSelfLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @CrossOrigin
    @GetMapping
    @Transactional
    public ResponseEntity<RestResponse<List<CategoryDTO>>> getAllCategories(){
        List<CategoryDTO> categories = categoryService.findAll();
        return RestResponseBuilder.build(
                categories,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<RestResponse<CategoryDTO>> getCategory(@PathVariable Long id) throws Exception {
        CategoryDTO category = categoryService.findById(id);
        return RestResponseBuilder.build(
                category,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @PostMapping()
    @Transactional
    public ResponseEntity<RestResponse<CategoryDTO>> createCategory(
            @RequestBody @JsonView(Views.CategoryRequest.class) CategoryDTO category
    ) {
        CategoryDTO createdCategory = categoryService.create(category);
        return RestResponseBuilder.build(
                createdCategory,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.CREATED
        );
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    public ResponseEntity<RestResponse<CategoryDTO>> updateCategory(
            @PathVariable Long id,
            @RequestBody @JsonView(Views.CategoryRequest.class) CategoryDTO category
    ) throws Exception {
        category.setId(id);
        CategoryDTO updatedCategory = categoryService.update(category);
        return RestResponseBuilder.build(
                updatedCategory,
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> deleteCategory(@PathVariable Long id) throws Exception {
        categoryService.delete(id);
        return RestResponseBuilder.build(
                "Category deleted successfully",
                GetResponseSelfLink.getSelfLink(),
                true,
                HttpStatus.OK
        );
    }
}
