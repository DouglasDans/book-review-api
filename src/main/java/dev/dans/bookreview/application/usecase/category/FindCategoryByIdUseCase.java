package dev.dans.bookreview.application.usecase.category;

import dev.dans.bookreview.domain.entities.Book;
import dev.dans.bookreview.domain.entities.Category;
import dev.dans.bookreview.domain.repository.CategoryRepository;
import dev.dans.bookreview.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCategoryByIdUseCase {
    private final CategoryRepository categoryRepository;

    public FindCategoryByIdUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isEmpty()) throw new ResourceNotFoundException("Category ID:" + id + " not found");

        return category.get();
    }
}
