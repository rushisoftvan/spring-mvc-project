package com.learn.service;

import com.learn.controller.CategoryController;
import com.learn.entity.CategoryEntity;
import com.learn.enums.StatusEnum;
import com.learn.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

    private Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveOrUpdate(CategoryEntity categoryEntity){
        log.debug("<<<<< saveOrUpdate()");
        if (Objects.isNull(categoryEntity.getId())){
            categoryEntity.setCreatedOn(LocalDateTime.now());
            categoryEntity.setUpdatedOn(LocalDateTime.now());
            categoryEntity.setActiveStatus(StatusEnum.ACTIVE);
            this.categoryRepository.save(categoryEntity);
        } else {
            this.update(categoryEntity);
        }
        log.debug("saveOrUpdate() >>>>>>");
    }

    private void update(CategoryEntity categoryEntity){
        CategoryEntity dbCategoryObject = this.categoryRepository.findById(categoryEntity.getId());
        dbCategoryObject.setUpdatedOn(LocalDateTime.now());
        dbCategoryObject.setActiveStatus(categoryEntity.getActiveStatus());
        dbCategoryObject.setName(categoryEntity.getName());
        this.categoryRepository.update(categoryEntity);
    }

    public List<CategoryEntity> getCategories(){
        return this.categoryRepository.findAll();
    }
}
