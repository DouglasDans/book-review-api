package dev.dans.bookreview.application.usecase.category;

import dev.dans.bookreview.domain.entities.Category;
import dev.dans.bookreview.domain.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllCategoriesUseCase {
    private final CategoryRepository categoryRepository;

    public FindAllCategoriesUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> execute() {
        return categoryRepository.findAll();
    }
}
