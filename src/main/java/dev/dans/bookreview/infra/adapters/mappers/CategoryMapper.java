package dev.dans.bookreview.infra.adapters.mappers;

import dev.dans.bookreview.domain.entities.Category;
import dev.dans.bookreview.infra.adapters.dtos.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public static Category toDomain(CategoryDTO categoryDTO){
        if(categoryDTO == null) return null;

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }

    public static CategoryDTO toJSON(Category category){
        if(category == null) return null;

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
