package dev.dans.bookreview.application.usecase.category;

import dev.dans.bookreview.domain.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public DeleteCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(Long id) {
        categoryRepository.deleteById(id);
    }
}
