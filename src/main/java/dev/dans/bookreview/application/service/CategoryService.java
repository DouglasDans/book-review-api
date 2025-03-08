package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.category.*;
import dev.dans.bookreview.domain.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CreateCategoryUseCase createCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;
    private final FindCategoryByIdUseCase findCategoryByIdUseCase;
    private final FindAllCategoriesUseCase findAllCategoriesUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;

    public CategoryService(CreateCategoryUseCase createCategoryUseCase, DeleteCategoryUseCase deleteCategoryUseCase, FindCategoryByIdUseCase findCategoryByIdUseCase, FindAllCategoriesUseCase findAllCategoriesUseCase, UpdateCategoryUseCase updateCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;
        this.findCategoryByIdUseCase = findCategoryByIdUseCase;
        this.findAllCategoriesUseCase = findAllCategoriesUseCase;
        this.updateCategoryUseCase = updateCategoryUseCase;
    }

    public Category create(Category category) {
        return createCategoryUseCase.execute(category);
    }

    public List<Category> findAll() {
        return findAllCategoriesUseCase.execute();
    }

    public Category findById(Long id) throws Exception {
        return findCategoryByIdUseCase.execute(id);
    }

    public Category update(Category category) throws Exception {
        findCategoryByIdUseCase.execute(category.getId());
        return updateCategoryUseCase.execute(category);
    }

    public void delete(Long id) throws Exception {
        findCategoryByIdUseCase.execute(id);
        deleteCategoryUseCase.execute(id);
    }
}