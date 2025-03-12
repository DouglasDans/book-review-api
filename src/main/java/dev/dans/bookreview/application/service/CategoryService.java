package dev.dans.bookreview.application.service;

import dev.dans.bookreview.application.usecase.category.*;
import dev.dans.bookreview.domain.entities.Category;
import dev.dans.bookreview.infra.adapters.dtos.CategoryDTO;
import dev.dans.bookreview.infra.adapters.mappers.CategoryMapper;
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

    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toDomain(categoryDTO);
        category = createCategoryUseCase.execute(category);
        return CategoryMapper.toJSON(category);
    }

    public List<CategoryDTO> findAll() {
        List<Category> categories = findAllCategoriesUseCase.execute();
        return categories.stream()
                .map(CategoryMapper::toJSON)
                .collect(java.util.stream.Collectors.toList());
    }

    public CategoryDTO findById(Long id) throws Exception {
        Category category = findCategoryByIdUseCase.execute(id);
        return CategoryMapper.toJSON(category);
    }

    public CategoryDTO update(CategoryDTO categoryDTO) throws Exception {
        Category category = CategoryMapper.toDomain(categoryDTO);
        findCategoryByIdUseCase.execute(category.getId());
        category = updateCategoryUseCase.execute(category);
        return CategoryMapper.toJSON(category);
    }

    public void delete(Long id) throws Exception {
        findCategoryByIdUseCase.execute(id);
        deleteCategoryUseCase.execute(id);
    }
}