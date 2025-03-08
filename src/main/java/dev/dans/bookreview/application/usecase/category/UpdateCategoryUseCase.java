package dev.dans.bookreview.application.usecase.category;

import dev.dans.bookreview.domain.entities.Category;
import dev.dans.bookreview.domain.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public UpdateCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(Category category) {
        return categoryRepository.save(category);
    }
}
