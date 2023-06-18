package com.learn.service;

import com.learn.entity.CategoryEntity;
import com.learn.entity.ProductEntity;
import com.learn.enums.StatusEnum;
import com.learn.repository.CategoryRepository;
import com.learn.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {


    private Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    public void save(ProductEntity productEntity) {
        log.debug("<<<<<< save()");
        CategoryEntity dbCategoryObject = this.categoryRepository.findById(productEntity.getCategory().getId());
        productEntity.setUpdatedOn(LocalDateTime.now());
        productEntity.setCreatedOn(LocalDateTime.now());
        productEntity.setActiveStatus(StatusEnum.ACTIVE);
        productEntity.setCategory(dbCategoryObject);
        this.productRepository.save(productEntity);
        log.debug("save() >>>>>>>");
    }

    public List<ProductEntity> getProducts(){
        return this.productRepository.findAll();
    }

    public ProductEntity getProduct(Integer id){
        return this.productRepository.findById(id);
    }

    public void update(ProductEntity productEntity) {
        log.debug("<<<<<< update()");
        CategoryEntity dbCategoryObject = this.categoryRepository.findById(productEntity.getCategory().getId());
        ProductEntity dbProductObject = this.productRepository.getById(productEntity.getId());
        dbProductObject.setName(productEntity.getName());
        dbProductObject.setPrice(productEntity.getPrice());
        dbProductObject.setUpdatedOn(LocalDateTime.now());
        dbProductObject.setActiveStatus(productEntity.getActiveStatus());
        dbProductObject.setCategory(dbCategoryObject);
        this.productRepository.update(dbProductObject);
        log.debug("update() >>>>>>>");
    }


}
